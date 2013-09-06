package de.scheduler.generator.parallel.priority;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Test;

import de.scheduler.generator.parallel.MockActivity;
import de.scheduler.generator.parallel.MockSmallestDurationRule;

public class SmallestDurationRuleTest {

	@Test
	public void testSmalestDurationRule() {

		// SmallestDurationRule is tested
		PriorityQueue<MockActivity> pr = new PriorityQueue<MockActivity>(10,
				MockSmallestDurationRule.INSTANCE);

		MockActivity a1 = new MockActivity(10, 100, null);
		MockActivity a2 = new MockActivity(17, 23, null);
		MockActivity a3 = new MockActivity(5, 500, null);

		pr.add(a1);
		pr.add(a2);
		pr.add(a3);

		assertEquals("SmallestDurationRule ", 17, pr.poll().getId());
	}
}
