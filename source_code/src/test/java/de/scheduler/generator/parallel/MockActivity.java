package de.scheduler.generator.parallel;

import java.util.Map;

public class MockActivity {
	private final int id;
	private final int duration;
	private final Map<Integer, Integer> resourceConstraints;
	private MockActivity[] predecesors;
	public boolean isFinished;

	public MockActivity(final int id, final int duration,
			final Map<Integer, Integer> resourceConstraints) {
		this.id = id;
		this.duration = duration;
		this.resourceConstraints = resourceConstraints;// resource dependency type1 -> 7, type 10 -> 4
	}
	
	public void setPredecessors(final MockActivity[] predecesors) {
		 this.predecesors = predecesors;
	}
	
	public void setIsFinished(final boolean isFinished) {
		 this.isFinished = isFinished;
	}

	public int getId() {
		return id;
	}

	public int getDuration() {
		return duration;
	}

	public Map<Integer, Integer> getResourceContstraints() {
		return resourceConstraints;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public boolean arePredecessorsFulfiled() {
		if(predecesors == null) { 
			return true;
		}
		for (MockActivity a : predecesors) {
			if (!a.isFinished()) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() { 
		return "Activity:" + id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MockActivity other = (MockActivity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
