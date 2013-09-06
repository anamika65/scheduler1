package de.scheduler.generator.serial;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.apache.log4j.Logger;

import de.scheduler.generator.AvailabilityResourceManger;
import de.scheduler.generator.ResourceLabelToIndex;
import de.scheduler.generator.Scheduler;
import de.scheduler.model.OpBlock;
import de.scheduler.util.OpBlockType;
import de.scheduler.util.ResourceType;

/**
 * Computes the operation block schedule, by using the serial heuristic method.
 * 
 * @author Gheorghe Pucea
 * 
 */
public class SerialScheduler implements Scheduler<OpBlock> {
	
	private static Logger logger = Logger.getLogger(SerialScheduler.class);
	
	private Set<Integer> completeSet;
	private Queue<OpBlock> decisionSet;
	private Map<Integer, Map<Integer, Integer>> resources;
	private AvailabilityResourceManger resManager;
	// map holding the activity with the corresponding id
	private Map<Integer, OpBlock> activities;
	private Map<Integer, Map<Integer, Integer>> activityConstraints;
	private final int noOfActivities;
	private Comparator<OpBlock> priorityRule;
	private ResourceLabelToIndex resToIndex;
	private Map<Integer, List<OpBlock>> resSchedule;
	private int maxNumberOfPeriods;

	public SerialScheduler(Map<Integer, OpBlock> activities,
			AvailabilityResourceManger resManager, int maxNumberOfPeriods,
			ResourceLabelToIndex resToIndex, Comparator<OpBlock> priorityRule) {
		this.activities = activities;
		this.resToIndex = resToIndex;
		this.noOfActivities = activities.size();
		this.resManager = resManager;
		this.priorityRule = priorityRule;
		this.resSchedule = new HashMap<Integer, List<OpBlock>>();
		this.maxNumberOfPeriods = maxNumberOfPeriods;
		this.activityConstraints = new HashMap<Integer, Map<Integer, Integer>>();
	}

	@Override
	public Map<Integer, List<OpBlock>> schedule() {
		init();
		while (completeSet.size() < noOfActivities) {
			decisionSet = computeDecisionSet();
			OpBlock currentActivity = decisionSet.poll();
			boolean isActivityScheduled = false;
			//try to schedule the currentActivity in one of the below periods
			for(int i=1; i <= maxNumberOfPeriods; i++) { 
				if(areEnoughResources(currentActivity, i)) { 
					scheduleOpBlockInPeriod(currentActivity, i);
					isActivityScheduled = true;
					break;
				}
			}
			//if the activity was not successfully scheduled log this problem.
			if(!isActivityScheduled) { 
				logger.debug("Could not schedule activity with id: " + currentActivity.getOpBlockId());
			}
			//we need to add the activity to the completed set because
			//we have to ensure that the algorithm finishes.
			completeSet.add(currentActivity.getOpBlockId());
		}
		return resSchedule;
	}

	/**
	 * Compute decision set, the activities that have all predecessors finished 
	 * and are not already completed.
	 * 
	 * @return the decision set
	 */
	private Queue<OpBlock> computeDecisionSet() {
		// clear all the operation blocks in the current
		// decision set
		decisionSet.clear();
		for (Entry<Integer, OpBlock> entry : activities.entrySet()) {
			OpBlock actv = entry.getValue();
			if ((!completeSet.contains(actv.getOpBlockId()) && actv.arePredecessorsFulfiled())) {
				decisionSet.add(actv);
			}
		}
		return decisionSet;
	}

	/**
	 * Inits the data structures for the current schedule.
	 */
	private void init() {
		completeSet = new HashSet<Integer>();
		decisionSet = new PriorityQueue<OpBlock>(10, priorityRule);
		resources = new HashMap<Integer, Map<Integer, Integer>>();
	}

	/**
	 * Schedule op block in currentPeriod by adding this block in the output
	 * map and adjusting the resources for this period.
	 *
	 * @param currentActivity the current activity that is scheduled
	 * @param period the period
	 */
	private void scheduleOpBlockInPeriod(OpBlock currentActivity, int period) {
		List<OpBlock> scheduledBlocks;
		//add the scheduled operation to the scheduled operations
		if (!resSchedule.containsKey(period)) {
			scheduledBlocks = new LinkedList<OpBlock>();
			scheduledBlocks.add(currentActivity);
			resSchedule.put(period, scheduledBlocks);
		} else {
			scheduledBlocks = resSchedule.get(period);
			scheduledBlocks.add(currentActivity);
		}
		
		//adjust the resource set for this period
		this.updateResourcesSet(currentActivity, period);
	}

	/**
	 * Compute resources set for the specified period. Note that it computes the
	 * remaining resources for this period by removing the resources needed for the 
	 * currentActivity.
	 * 
	 * @param period
	 *            the time period
	 * @return the remaining resources for this period
	 */
	private Map<Integer, Map<Integer, Integer>> updateResourcesSet(OpBlock currentActivity, int period) {
		Map<Integer, Integer> availiableResourceForPeriod = getResourceForPeriod(period);

		Map<Integer, Integer> activityConstraints = getResourceContstraints(currentActivity);
		for (Map.Entry<Integer, Integer> entry : activityConstraints
				.entrySet()) {

			int currentAvailable = availiableResourceForPeriod.get(entry
					.getKey());
			int needed = entry.getValue();

			if (currentAvailable < needed) {
				throw new IllegalArgumentException(
						" currentAvailable < needed ");
			}
			availiableResourceForPeriod.put(entry.getKey(),
					currentAvailable - needed);
		}
		// setting this block to finished, including dummy operations
		currentActivity.setActualSize(currentActivity.getDefaultSize());
		return resources;
	}

	/**
	 * Gets the resource set with the availability for all resources for this period.
	 *
	 * @param period the period
	 * @return the resource for period
	 */
	private Map<Integer, Integer> getResourceForPeriod(int period) {
		Map<Integer, Integer> availiableResourceForPeriod;
		if (!resources.containsKey(period)) {
			// if no resource constraints are already defined, fetch them from
			// resource manager
			availiableResourceForPeriod = new HashMap<Integer, Integer>();
			for (Map.Entry<Integer, Integer> entry : resManager
					.getResourceAvailabilty(period).entrySet()) {
				availiableResourceForPeriod.put(entry.getKey(),
						entry.getValue());
			}
			resources.put(period, availiableResourceForPeriod);
		} else {
			// get current resource constraints from the specified period
			availiableResourceForPeriod = resources.get(period);
		}
		return availiableResourceForPeriod;
	}

	/**
	 * Gets the resource constraints for the block specified by parameter.
	 * 
	 * @param act
	 *            the operation block
	 * @return the resource constraints as a map of (resourceID, value)
	 */
	private Map<Integer, Integer> getResourceContstraints(OpBlock act) {
		Map<Integer, Integer> constraints;
		int id = act.getOpBlockId();
		if (!activityConstraints.containsKey(id)) {
			constraints = new HashMap<Integer, Integer>();
			if (!act.getType().equals(OpBlockType.DUMMY.toString())) {
				int residentNoOpIndex = resToIndex
						.getIndexForLabel(ResourceType.PROJECT_CAPACITY.toString()
								+ act.getProjectID());
				int operationConstrIndex = resToIndex.getIndexForLabel(act
						.getConstraintLabel());

				int numberOfOperations = act.getDefaultSize()
						- act.getActualSize();
				constraints.put(residentNoOpIndex, numberOfOperations);
				constraints.put(operationConstrIndex, numberOfOperations);
			}
			activityConstraints.put(id, constraints);
		} else {
			constraints = activityConstraints.get(id);
		}
		return constraints;
	}

	/**
	 * Checks if there are enough resources to schedule this operation block in
	 * the given time period.
	 * 
	 * @param act
	 *            the operation block
	 * @param period
	 *            the time period
	 * @return true, if successful
	 */
	public boolean areEnoughResources(OpBlock act, int period) {
		Map<Integer, Integer> availiableResourceForTg = getResourceForPeriod(period);
		Map<Integer, Integer> activityConstraints = null;
		try {
			activityConstraints = getResourceContstraints(act);
		}catch (Exception e) {
			logger.debug(e.getLocalizedMessage());
		}
		for (Map.Entry<Integer, Integer> entry : activityConstraints.entrySet()) {
			int currentAvailable = availiableResourceForTg.get(entry.getKey());
			int needed = entry.getValue();
			if (currentAvailable < needed) {
				return false;
			}
		}
		return true;
	}
}
