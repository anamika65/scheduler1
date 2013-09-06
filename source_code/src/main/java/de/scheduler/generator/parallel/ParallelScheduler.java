package de.scheduler.generator.parallel;

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
import java.util.SortedSet;
import java.util.TreeSet;

import de.scheduler.generator.AvailabilityResourceManger;
import de.scheduler.generator.ResourceLabelToIndex;
import de.scheduler.generator.Scheduler;
import de.scheduler.model.OpBlock;
import de.scheduler.util.OpBlockType;
import de.scheduler.util.ResourceType;

/**
 * Computes the operation block schedule, by using the parallel heuristic method.
 * 
 * @author Gheorghe Pucea
 * 
 */
public class ParallelScheduler implements Scheduler<OpBlock> {
	private Set<Integer> completeSet;
	private SortedSet<OpBlock> activeSet;
	private Queue<OpBlock> decisionSet;
	private Map<Integer, Map<Integer, Integer>> resources;
	private AvailabilityResourceManger resManager;
	private int timePeriod;
	// map holding the activity with the corresponding id
	private Map<Integer, OpBlock> activities;
	private Map<Integer, Map<Integer, Integer>> activityConstraints;
	private final int noOfActivities;
	private Comparator<OpBlock> priorityRule;
	private ResourceLabelToIndex resToIndex;
	private Map<Integer, List<OpBlock>> resSchedule;
	private int maxNumberOfPeriods;

	public ParallelScheduler(Map<Integer, OpBlock> activities,
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
		while ((completeSet.size() + activeSet.size() < noOfActivities)
				&& (maxNumberOfPeriods >= timePeriod)) {
			timePeriod++;
			completeSet = computeCompletedSet();
			resources = computeResourcesSet(timePeriod);
			decisionSet = computeDecisionSet(timePeriod);
			while (!decisionSet.isEmpty()) {
				OpBlock currentActivity = decisionSet.poll();
				scheduleOpBlockInPeriod(currentActivity);
				activeSet.add(currentActivity);
				resources = computeResourcesSet(timePeriod);
				// here the activities are set to finish, note
				decisionSet = computeDecisionSet(timePeriod);
				completeSet = computeCompletedSet();
			}
		}
		return resSchedule;
	}

	/**
	 * Compute decision set for this period by checking which operation block
	 * has all predecessors fulfilled and if there are enough resources.
	 * 
	 * @param period
	 *            the time period
	 * @return the decision set
	 */
	private Queue<OpBlock> computeDecisionSet(int period) {
		// clear all the operation blocks in the current
		// decision set
		decisionSet.clear();
		for (Entry<Integer, OpBlock> entry : activities.entrySet()) {
			OpBlock actv = entry.getValue();
			if ((!actv.isFinished()) && actv.arePredecessorsFulfiled()
					&& areEnoughResources(actv, period)) {
				decisionSet.add(actv);
			}
		}
		return decisionSet;
	}

	/**
	 * Compute completed set by adding all the active operation block from the
	 * active set in the complete set.
	 * 
	 * @return the sets the
	 */
	private Set<Integer> computeCompletedSet() {
		if (activeSet.isEmpty())
			return completeSet;
		for (OpBlock actv : activeSet) {
			int id = actv.getOpBlockId();
			activeSet.remove(actv);
			completeSet.add(id);
		}
		return completeSet;
	}

	/**
	 * Inits the data structures for the current schedule.
	 */
	private void init() {
		completeSet = new HashSet<Integer>();
		activeSet = new TreeSet<OpBlock>(priorityRule);
		decisionSet = new PriorityQueue<OpBlock>(10, priorityRule);
		resources = new HashMap<Integer, Map<Integer, Integer>>();
		timePeriod = 0;
	}

	/**
	 * Schedule op block in currentPeriod by adding this block in the output
	 * map.
	 * 
	 * @param currentActivity
	 *            the current activity that is scheduled
	 */
	private void scheduleOpBlockInPeriod(OpBlock currentActivity) {
		List<OpBlock> scheduledBlocks;
		if (!resSchedule.containsKey(timePeriod)) {
			scheduledBlocks = new LinkedList<OpBlock>();
			scheduledBlocks.add(currentActivity);
			resSchedule.put(timePeriod, scheduledBlocks);
		} else {
			scheduledBlocks = resSchedule.get(timePeriod);
			scheduledBlocks.add(currentActivity);
		}
	}

	/**
	 * Compute resources set for the specified period. Note that it computes the
	 * remaining resources for this period by removing the resources needed by
	 * the operation blocks in the active set.
	 * 
	 * @param period
	 *            the time period
	 * @return the remaining resources for this period
	 */
	private Map<Integer, Map<Integer, Integer>> computeResourcesSet(int period) {
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
		} else {
			// get current resource constraints from the specified period
			availiableResourceForPeriod = resources.get(period);
		}

		for (OpBlock act : activeSet) {
			Map<Integer, Integer> activityConstraints = getResourceContstraints(act);
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
			act.setActualSize(act.getDefaultSize());
		}

		resources.put(period, availiableResourceForPeriod);

		return resources;
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
		Map<Integer, Integer> availiableResourceForTg = resources.get(period);
		
		Map<Integer, Integer> activityConstraints = null;
		try {
			activityConstraints = getResourceContstraints(act);
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
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
