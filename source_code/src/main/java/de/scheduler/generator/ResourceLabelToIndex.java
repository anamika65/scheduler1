package de.scheduler.generator;

import java.util.HashMap;
import java.util.Map;

/*
 * Utility class transforming label into indexes and vice versa
 * 
 */

public class ResourceLabelToIndex {
	Map<Integer, String> indexToLabel;
	Map<String, Integer> labelToIndex;
	private int currentCount;

	public ResourceLabelToIndex() {
		indexToLabel = new HashMap<Integer, String>();
		labelToIndex = new HashMap<String, Integer>();
		currentCount = 0;
	}

	public int setIndexForLabel(String label) {
		currentCount++;
		indexToLabel.put(currentCount, label);
		labelToIndex.put(label, currentCount);
		return currentCount;
	}

	public int getIndexForLabel(String label) {
		return labelToIndex.get(label);
	}

	public String getLabelForIndex(int index) {
		return indexToLabel.get(index);
	}

}
