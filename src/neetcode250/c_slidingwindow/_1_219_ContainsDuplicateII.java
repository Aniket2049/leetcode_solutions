package neetcode250.c_slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/
// https://www.youtube.com/watch?v=ypn0aZ0nrL4
public class _1_219_ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
				return true;
			}
			map.put(nums[i], i);
		}

		return false;
	}
}
