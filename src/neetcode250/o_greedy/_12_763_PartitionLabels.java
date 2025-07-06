package neetcode250.o_greedy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
// https://www.youtube.com/watch?v=aUVEMnlcw4E
public class _12_763_PartitionLabels {
	public List<Integer> partitionLabels(String str) {
		List<Integer> partitions = new ArrayList<>();

		for (int i = 0; i < str.length();) {

			// Get first and last index of first character
			int startIndex = i;
			int endIndex = str.lastIndexOf(str.charAt(startIndex));

			for (int s = startIndex + 1; s <= endIndex - 1; s++) {

				// Find last index of any subsequent characters
				int lastIndexOfNextChar = str.lastIndexOf(str.charAt(s));

				if (lastIndexOfNextChar > endIndex) {
					// Update endIndex if required
					endIndex = lastIndexOfNextChar;
				}
			}

			partitions.add(endIndex - startIndex + 1);
			i = endIndex + 1;
		}

		return partitions;	
	}
}
