package neetcode250.o_greedy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
// https://www.youtube.com/watch?v=kShkQLQZ9K4
public class _11_1899_MergeTripletsToFormTargetTriplet {
	public boolean mergeTriplets(int[][] triplets, int[] target) {
		Set<Integer> good = new HashSet<>();

		for (int[] t : triplets) {
			if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
				continue;
			}
			for (int i = 0; i < t.length; i++) {
				if (t[i] == target[i]) {
					good.add(i);
				}
			}
		}
		return good.size() == 3;
	}
}
