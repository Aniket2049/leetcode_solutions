package neetcode150.o_greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/partition-labels/
// https://www.youtube.com/watch?v=B7m8UmZE-vw
public class _7_763_PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		Map<Character, Integer> lastIndex = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			lastIndex.put(s.charAt(i), i);
		}

		List<Integer> res = new ArrayList<>();
		int size = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			size++;
			end = Math.max(end, lastIndex.get(s.charAt(i)));

			if (i == end) {
				res.add(size);
				size = 0;
			}
		}
		return res;
	}
}
