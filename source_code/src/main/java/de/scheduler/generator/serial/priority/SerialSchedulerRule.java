package de.scheduler.generator.serial.priority;

import java.util.Comparator;

import de.scheduler.model.OpBlock;

public class SerialSchedulerRule implements Comparator<OpBlock> {
    public static SerialSchedulerRule INSTANCE = new SerialSchedulerRule();
    
	@Override
	public int compare(OpBlock o1, OpBlock o2) {
		//comparing the actual block id in ascending order
		return Integer.valueOf((o1.getOpBlockId()).compareTo(o2.getOpBlockId()));
	}
}
