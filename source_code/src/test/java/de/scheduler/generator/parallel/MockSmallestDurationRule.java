package de.scheduler.generator.parallel;

import java.util.Comparator;

import static java.lang.Integer.valueOf;

public class MockSmallestDurationRule implements Comparator<MockActivity> {
    public static MockSmallestDurationRule INSTANCE = new MockSmallestDurationRule();
    
	public int compare(MockActivity o1, MockActivity o2) {
		return valueOf(o1.getDuration()).compareTo(o2.getDuration());
	}

}
