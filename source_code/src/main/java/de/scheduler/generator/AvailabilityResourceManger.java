package de.scheduler.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Resource Manager. 
 * Handles resource constraints for a specific period of time.
 * If no constraints are specified the default availability constraints
 * are saved at key 0 in the hash table.
 * 
 * @author george
 *
 */
public class AvailabilityResourceManger {
	
	private Map<Integer, Map<Integer, Integer>> resources;
	
	public AvailabilityResourceManger(Map<Integer, Integer> defaultAvailability) { 
		resources = new HashMap<Integer, Map<Integer, Integer>>();
		resources.put(0, defaultAvailability);
	}
	
	public void addResourceAvailability(int period, Map<Integer, Integer> availability) { 
		resources.put(period, availability);
	}
	
	public Map<Integer, Integer> getResourceAvailabilty(int period) { 
		if(resources.containsKey(period)) { 
			return resources.get(period);
		}
		return resources.get(0);
	}
	
	public boolean containsAvailabilityForPeriod(int period) { 
		return resources.containsKey(period);
	}

}
