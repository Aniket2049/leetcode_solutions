package neetcode250.a_arrays;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
// https://www.youtube.com/watch?v=7jDS9KQEDbI
public class _4_1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int currentElement = nums[i];
			int leftOver = target - currentElement;

			if (myMap.containsKey(leftOver)) {
				return new int[] { myMap.get(leftOver), i };
			} else {
				myMap.put(nums[i], i);
			}
		}

		return new int[] {};
	}
}
