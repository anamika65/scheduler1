package de.scheduler.generator;

import java.util.List;
import java.util.Map;

/**
 * Scheduler interface, that specifies the output type of a valid Schedule.
 * 
 * @param <E>
 *            the element type
 */
public interface Scheduler<E> {

	/**
	 * Schedules activities for a period of time and returns the schedule in a
	 * map which holds for every period the scheduled activities.
	 * 
	 * @return the map
	 */
	Map<Integer, List<E>> schedule();
}
