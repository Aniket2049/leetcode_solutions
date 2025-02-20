package neetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/description/
// https://www.youtube.com/watch?v=KLlXCFG5TnA
public class _3_1_TwoSum {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> prevMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int diff = target - num;

			if (prevMap.containsKey(diff)) {
				return new int[] { prevMap.get(diff), i };
			}

			prevMap.put(num, i);
		}

		return new int[] {};
	}

	public static void main(String[] args) {
//		Input: nums = [2,7,11,15], target = 9
//		Output: [0,1]

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		_3_1_TwoSum obj = new _3_1_TwoSum();
		System.out.println(Arrays.toString(obj.twoSum(nums, target)));

	}

}
