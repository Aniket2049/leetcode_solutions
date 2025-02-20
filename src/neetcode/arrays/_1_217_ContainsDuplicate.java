package neetcode.arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate/description/
// https://www.youtube.com/watch?v=3OamzN90kPg
public class _1_217_ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length < 1)
			return false;
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int currentElement = nums[i];

			if (myMap.containsKey(currentElement)) {
				return true;
			} else {
				myMap.put(currentElement, currentElement);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		System.out.println(new _1_217_ContainsDuplicate().containsDuplicate(nums));
	}

}
