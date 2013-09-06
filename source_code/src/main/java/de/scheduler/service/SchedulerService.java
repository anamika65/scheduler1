package de.scheduler.service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.springframework.stereotype.Service;

import de.scheduler.generator.AvailabilityResourceManger;
import de.scheduler.generator.ResourceLabelToIndex;
import de.scheduler.generator.Scheduler;
import de.scheduler.generator.parallel.ParallelScheduler;
import de.scheduler.generator.parallel.priority.ParallelSchedulerRule;
import de.scheduler.model.OpBlock;
import de.scheduler.model.OpCatalogue;
import de.scheduler.model.Project;
import de.scheduler.util.DifficultyLevel;
import de.scheduler.util.OpBlockType;
import de.scheduler.util.ResourceType;
import de.scheduler.util.Settings;

@Service("schedulerService")
public class SchedulerService {

	@Resource(name = "opBlockService")
	private OpBlockService opBlockService;

	@Resource(name = "projectService")
	private ProjectService projectService;

	@Resource(name = "opCatalogueService")
	private OpCatalogueService catalogService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	/**
	 * Generates the resident schedule for the current month.
	 * 
	 * @return 	the map containing all the projects that have to perform
	 *         	operations in the current month and the Opblocks that must be
	 *         	performed.
	 */
	public Map<Project, List<OpBlock>> generateSchedule(Integer specialtyID) {
		// load the activities for the current schedule
		Map<Integer, OpBlock> activities = getActivitiesForSchedule(specialtyID);

		// build the resource Manager
		ResourceLabelToIndex resToIndex = new ResourceLabelToIndex();
		AvailabilityResourceManger resourceManager = initResources(resToIndex, specialtyID);

		// gets a scheduler instance
		Scheduler<OpBlock> scheduler = this.getScheduler(activities,
				resToIndex, resourceManager);

		// schedule for current month
		Map<Integer, List<OpBlock>> schedule = scheduler.schedule();

		// retrieve the schedule for the first month only
		return getScheduleForPeriod(1, schedule, specialtyID);

	}

	/**
	 * Gets the activities for schedule, by loading the opblocks from the db.
	 * 
	 * @return 		the activities for schedule
	 */
	private Map<Integer, OpBlock> getActivitiesForSchedule(Integer specialtyID) {
		Map<Integer, OpBlock> activities = new HashMap<Integer, OpBlock>();
		
		// load the operation blocks that are incomplete for the active
		// residents or for residents that are in vacation.
		List<OpBlock> incompleteActivities = opBlockService
				.getIncompleteOpBlocksForSpecialty(specialtyID);
		for (OpBlock o : incompleteActivities) {
			activities.put(o.getOpBlockId(), o);
		}
		return activities;
	}

	/**
	 * Gets the parallel scheduler instace.
	 * 
	 * @param activities 		the activities
	 * @param resToIndex 		the res to index
	 * @param resourceManager 	the resource manager
	 * 
	 * @return 		the scheduler
	 */
	private Scheduler<OpBlock> getScheduler(Map<Integer, OpBlock> activities,
			ResourceLabelToIndex resToIndex,
			AvailabilityResourceManger resourceManager) {
		// Retrieve the training duration in months
		String trainingDuration = configurationService
				.getConfigurationValue(Settings.TRAINING_DURATION);

		return new ParallelScheduler(activities, resourceManager,
				Integer.valueOf(trainingDuration), resToIndex,
				ParallelSchedulerRule.INSTANCE);
	}

	/**
	 * Inits the resource manger. This manager is used to calculate for every
	 * month the availability of resources. Eg. resident capacity, number of
	 * easy operations from the Hernia catalogue etc...
	 * 
	 * @param resToIndex 		the res to index
	 * 
	 * @return 		the availability resource manger
	 */
	private AvailabilityResourceManger initResources(
			ResourceLabelToIndex resToIndex, int specialtyID) {
		// initialize the resource map
		Map<Integer, Integer> resources = new HashMap<Integer, Integer>();

		// calculate available number of operations for each catalog
		for (OpCatalogue catalogue : catalogService.getAllForSpecialty(specialtyID)) {

			int[] monthlyCapacityOp = getMonthlyCapacity(catalogue);

			int resIndexEasy = resToIndex
					.setIndexForLabel(ResourceType.OPERATION_CAPACITY.toString()
							+ catalogue.getCatalogueID()
							+ DifficultyLevel.EASY.toString());
			resources.put(resIndexEasy, monthlyCapacityOp[0]);

			int resIndexNormal = resToIndex
					.setIndexForLabel(ResourceType.OPERATION_CAPACITY.toString()
							+ catalogue.getCatalogueID()
							+ DifficultyLevel.NORMAL.toString());
			resources.put(resIndexNormal, monthlyCapacityOp[1]);

			int resIndexDifficult = resToIndex
					.setIndexForLabel(ResourceType.OPERATION_CAPACITY.toString()
							+ catalogue.getCatalogueID()
							+ DifficultyLevel.DIFFICULT.toString());
			resources.put(resIndexDifficult, monthlyCapacityOp[2]);
		}

		List<Project> projects = projectService.getAllForSpecialty(specialtyID);
		
		// calculate available number of operations for each project per month
		for (Project project : projects) {
			int res = resToIndex.setIndexForLabel(ResourceType.PROJECT_CAPACITY
					.toString() + project.getProjectID());

			resources.put(res, project.getCapacity());
		}

		AvailabilityResourceManger resourceManager = new AvailabilityResourceManger(
				resources);
		
		//update the the capacity of residents that are on vacation
		for (Project project : projects) {
			if ((!project.isActive()) && (project.getDeactivatedUntil() != null)) {

				Period difference = calculateVacationPeriod(new Date(), project.getDeactivatedUntil());
				int months = difference.getMonths();
				int period = 1;
				while (period <= months) {
					Map<Integer, Integer> availiableResourceForPeriod = getResourceAvailabilityForPeriod(
							period, resourceManager);
					// get the index for the current project
					int projectIndex = resToIndex
							.getIndexForLabel(ResourceType.PROJECT_CAPACITY
									.toString() + project.getProjectID());
					// set the capacity of this project to 0 because it is
					// unavailable.
					availiableResourceForPeriod.put(projectIndex, 0);

					resourceManager.addResourceAvailability(period,
							availiableResourceForPeriod);
					period++;
				}
				//calculate the remaining days of vacation
				int days = difference.getDays();
				if (days != 0) {
					Map<Integer, Integer> availiableResourceForPeriod = getResourceAvailabilityForPeriod(
							period, resourceManager);
					int averageNoDaysInMonth = 30;
					int capacityForRemainingDays = Math.round((days * project.getCapacity()) / averageNoDaysInMonth);
					// get the index for the current project
					int projectIndex = resToIndex
							.getIndexForLabel(ResourceType.PROJECT_CAPACITY
									.toString() + project.getProjectID());
					// set the capacity of this project to 0 because it is
					// unavailable.
					availiableResourceForPeriod.put(projectIndex,
							project.getCapacity() - capacityForRemainingDays);
					resourceManager.addResourceAvailability(period,
							availiableResourceForPeriod);
				}

			}
		}
		return resourceManager;
	}

	/**
	 * Calculates the vacation period for a given start and end date.
	 *
	 * @param start 		the start date
	 * @param end 			the end date
	 * 
	 * @return 		the duration
	 */
	private Period calculateVacationPeriod(Date start, Date end) {
		LocalDate startDate = new LocalDate(start);
		LocalDate endDate = new LocalDate(end);
		PeriodType monthDay = PeriodType.yearMonthDay();
		Period difference = new Period(startDate, endDate.plusDays(1),
				monthDay);
		return difference;
	}


	/**
	 * Gets the resource availability for period, if no resource availability for this period is provided 
	 * the default availability is copied and used instead.
	 *
	 * @param period 			the period
	 * @param resourceManager 	the resource manager
	 * 
	 * @return 		the resource availability for period
	 */
	private Map<Integer, Integer> getResourceAvailabilityForPeriod(int period,
			AvailabilityResourceManger resourceManager) {
		Map<Integer, Integer> availiableResourceForPeriod;
		if (!resourceManager.containsAvailabilityForPeriod(period)) {
			// if no resource constraints are already defined, fetch
			// them from resource manager
			availiableResourceForPeriod = new HashMap<Integer, Integer>(
					resourceManager.getResourceAvailabilty(0));
		} else {
			// get current resource constraints from the specified period
			availiableResourceForPeriod = resourceManager
					.getResourceAvailabilty(period);
		}
		return availiableResourceForPeriod;
	}

	/**
	 * Retrieves from the fullSchedule, aka the schedule for the whole resident
	 * training, only the schedule for the month specified by the period
	 * parameter.
	 * 
	 * @param period 			the period
	 * @param fullSchedule 		the full schedule
	 * 
	 * @return 		the schedule for period
	 */
	public Map<Project, List<OpBlock>> getScheduleForPeriod(int period,
			Map<Integer, List<OpBlock>> fullSchedule, int specialtyID) {

		Map<Project, List<OpBlock>> schedule = new HashMap<Project, List<OpBlock>>();
		List<OpBlock> scheduledBlocks = fullSchedule.get(period);
		if (scheduledBlocks != null) {
			for (Project project : projectService.getAllForSpecialty(specialtyID)) {
				List<OpBlock> schBlockForResidents = new LinkedList<OpBlock>();
				for (OpBlock o : scheduledBlocks) {
					if (o.getType().equalsIgnoreCase(
							OpBlockType.NORMAL.toString())
							&& o.getProjectID().equals(project.getProjectID())) {
						schBlockForResidents.add(o);
					}
				}
				if (schBlockForResidents.size() > 0) {
					schedule.put(project, schBlockForResidents);
				}
			}
		}
		return schedule;

	}

	/**
	 * Gets the monthly capacity for the given catalog for each difficulty
	 * level easy, normal, difficult.
	 * 
	 * @param catalogue 		the catalogue
	 * 
	 * @return 		 the monthly capacity
	 */
	private int[] getMonthlyCapacity(OpCatalogue catalogue) {
		int[] monthlyCapacity = { 0, 0, 0 };
		int totalNumberOfOp = catalogue.getLeve1OpNo()
				+ catalogue.getLeve2OpNo() + catalogue.getLeve3OpNo();
		if (totalNumberOfOp != 0) {
			int easyCapac = Math
					.round((catalogue.getMonthlyCapacity() * catalogue
							.getLeve1OpNo()) / totalNumberOfOp);
			monthlyCapacity[0] = easyCapac;

			int normalCapac = Math
					.round((catalogue.getMonthlyCapacity() * catalogue
							.getLeve2OpNo()) / totalNumberOfOp);
			monthlyCapacity[1] = normalCapac;

			int difficultCapac = Math
					.round((catalogue.getMonthlyCapacity() * catalogue
							.getLeve3OpNo()) / totalNumberOfOp);
			monthlyCapacity[2] = difficultCapac;
		}
		return monthlyCapacity;
	}

}
