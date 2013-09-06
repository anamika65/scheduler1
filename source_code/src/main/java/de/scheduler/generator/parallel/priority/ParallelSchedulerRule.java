package de.scheduler.generator.parallel.priority;

import java.util.Comparator;

import de.scheduler.model.OpBlock;

public class ParallelSchedulerRule implements Comparator<OpBlock> {
    public static ParallelSchedulerRule INSTANCE = new ParallelSchedulerRule();
    
	@Override
	public int compare(OpBlock o1, OpBlock o2) {
		return Integer.valueOf((o1.getDefaultSize()).compareTo(o2.getDefaultSize()));
	}
}
