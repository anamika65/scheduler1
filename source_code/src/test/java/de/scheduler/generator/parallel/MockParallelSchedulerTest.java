package de.scheduler.generator.parallel;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.scheduler.generator.AvailabilityResourceManger;

public class MockParallelSchedulerTest {

	private Map<Integer, MockActivity> activities;
	private AvailabilityResourceManger resMan;

	@Before
	public void runBeforeEveryTest() {
		activities = new HashMap<Integer, MockActivity>();

		Map<Integer, Integer> const1 = new HashMap<Integer, Integer>();
		const1.put(1, 2);
		MockActivity a1 = new MockActivity(1, 3, const1);

		Map<Integer, Integer> const2 = new HashMap<Integer, Integer>();
		const2.put(1, 3);
		MockActivity a2 = new MockActivity(2, 4, const2);
		MockActivity[] p3 = { a1 };
		MockActivity[] p4 = { a2 };

		Map<Integer, Integer> const3 = new HashMap<Integer, Integer>();
		const3.put(1, 4);
		MockActivity a3 = new MockActivity(3, 2, const3);
		a3.setPredecessors(p3);

		MockActivity a4 = new MockActivity(4, 2, const3);
		a4.setPredecessors(p4);

		MockActivity[] p5 = { a3 };
		MockActivity[] p6 = { a4 };

		MockActivity a5 = new MockActivity(5, 1, const2);
		a5.setPredecessors(p5);

		MockActivity a6 = new MockActivity(6, 4, const1);
		a6.setPredecessors(p6);

		activities.put(1, a1);
		activities.put(2, a2);
		activities.put(3, a3);
		activities.put(4, a4);
		activities.put(5, a5);
		activities.put(6, a6);

		Map<Integer, Integer> resources = new HashMap<Integer, Integer>();
		resources.put(1, 4);
		resMan = new AvailabilityResourceManger(resources);

	}

	@Test
	public void testParallelScheduleWithSmallestDuration() {

		MockParallelScheduler scheduler = new MockParallelScheduler(activities, resMan,
				MockSmallestDurationRule.INSTANCE);
		int[] sch = scheduler.schedule();
		assertEquals("Schedule activity 1", sch[1], 0);
		assertEquals("Schedule activity 2", sch[2], 6);
		assertEquals("Schedule activity 3", sch[3], 3);
		assertEquals("Schedule activity 4", sch[4], 10);
		assertEquals("Schedule activity 5", sch[5], 5);
		assertEquals("Schedule activity 6", sch[6], 12);
	}

}
