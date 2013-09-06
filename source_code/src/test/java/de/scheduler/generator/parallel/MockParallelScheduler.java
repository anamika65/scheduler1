package de.scheduler.generator.parallel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import de.scheduler.generator.AvailabilityResourceManger;
/*
 * This class is actually a proof of concept of the parallel scheduling heuristic 
 *  method.
 */
public class MockParallelScheduler {
	private static final int NOT_SCHEDULED = -1;
	private Set<Integer> completeSet;
	private SortedSet<MockActivity> activeSet;
	private Queue<MockActivity> decisionSet;
	private Map<Integer, Map<Integer, Integer>> resources;
	private AvailabilityResourceManger resManager;
	private int tg;
	//map holding the activity with the corresponding id
	private Map<Integer, MockActivity> activities;
	private final int noOfActivities;
	private Comparator<MockActivity> priorityRule;

	// array holding schedule times of activities
	private final int[] scheduleTime;

	public MockParallelScheduler(Map<Integer, MockActivity> activities,
			AvailabilityResourceManger resManager,
			Comparator<MockActivity> priorityRule) {
		this.activities = activities;
		noOfActivities = activities.size() + 1; // handle 0 and n+1
		scheduleTime = new int[noOfActivities];
		for (int i = 0; i < noOfActivities; i++) {
			scheduleTime[i] = NOT_SCHEDULED;
		}
		this.resManager = resManager;
		this.priorityRule = priorityRule;
	}

	public int[] schedule() {
		init();
		while (completeSet.size() + activeSet.size() < noOfActivities) {
			// iterationStep++;
			tg = tg + minStartingTime();
			completeSet = computeCompletedSet(tg);
			// activeSet = computeActiveSet(tg);
			resources = computeResourcesSet(tg);
			decisionSet = computeDecisionSet(tg);
			while (!decisionSet.isEmpty()) {
				MockActivity j = decisionSet.poll();
				scheduleTime[j.getId()] = tg;
				// activeSet = computeActiveSet(tg);
				activeSet.add(j);
				//be aware BUG the active resources might be substracted multiple times
				resources = computeResourcesSet(tg);
				decisionSet = computeDecisionSet(tg);
			}
		}
		return scheduleTime;
	}

	private void init() {
		completeSet = new HashSet<Integer>();
		activeSet = new TreeSet<MockActivity>(priorityRule);
		decisionSet = new PriorityQueue<MockActivity>(10, priorityRule);
		resources = new HashMap<Integer, Map<Integer, Integer>>();
		//add dummy activity to the completed set
		completeSet.add(0);
		tg = 0;
		scheduleTime[0] = 0;
	}

	private Map<Integer, Map<Integer, Integer>> computeResourcesSet(int tg) {
		Map<Integer, Integer> availiableResourceForTg;
		if (!resources.containsKey(tg)) {
			// if no resource constraints are already defined, fetch them from
			// resource manager
			availiableResourceForTg = new HashMap<Integer, Integer>();
			for (Map.Entry<Integer, Integer> entry : resManager
					.getResourceAvailabilty(tg).entrySet()) {
				availiableResourceForTg.put(entry.getKey(), entry.getValue());
			}
		} else {
			// get current resource constraints from the specified period
			availiableResourceForTg = resources.get(tg);
		}

		for (MockActivity act : activeSet) {
			Map<Integer, Integer> activityConstraints = act
					.getResourceContstraints();
			for (Map.Entry<Integer, Integer> entry : activityConstraints
					.entrySet()) {

				int currentAvailable = availiableResourceForTg.get(entry
						.getKey());
				int needed = entry.getValue();

				if (currentAvailable < needed) {
					throw new IllegalArgumentException(
							" currentAvailable < needed ");
				}

				availiableResourceForTg.put(entry.getKey(), currentAvailable
						- needed);

			}
		}

		resources.put(tg, availiableResourceForTg);

		return resources;
	}

	private Queue<MockActivity> computeDecisionSet(int tg) {
		decisionSet = new PriorityQueue<MockActivity>(10,
				MockSmallestDurationRule.INSTANCE);
		for (int i = 0; i < scheduleTime.length; i++) {
			MockActivity actv = activities.get(i);
			if (actv == null)
				continue;
			if ((scheduleTime[i] == NOT_SCHEDULED)
					&& actv.arePredecessorsFulfiled()
					&& areEnoughResources(actv, tg)) {
				decisionSet.add(actv);
			}
		}

		return decisionSet;
	}

	public boolean areEnoughResources(MockActivity act, int tg) {
		Map<Integer, Integer> availiableResourceForTg = resources.get(tg);
		Map<Integer, Integer> activityConstraints = act
				.getResourceContstraints();
		for (Map.Entry<Integer, Integer> entry : activityConstraints.entrySet()) {
			int currentAvailable = availiableResourceForTg.get(entry.getKey());
			int needed = entry.getValue();

			if (currentAvailable < needed) {
				return false;
			}
		}
		return true;
	}

	private int minStartingTime() {
		if (!activeSet.isEmpty()) {
			return activeSet.first().getDuration();
		}
		return 0;
	}

	private Set<Integer> computeCompletedSet(int tg) {
		if (activeSet.isEmpty())
			return completeSet;
		for (MockActivity actv : activeSet) {
			int id = actv.getId();
			if (activities.get(id).getDuration() + scheduleTime[id] <= tg) {
				activeSet.remove(actv);
				actv.setIsFinished(true);
				completeSet.add(id);
			}
		}
		return completeSet;
	}
}
