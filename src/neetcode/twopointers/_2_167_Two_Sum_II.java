package neetcode.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// 
public class _2_167_Two_Sum_II {

	public int[] twoSum(int[] numbers, int target) {
		if (numbers.length == 2) {
			return new int[] { 1, 2 };
		}
		int l = 0;
		int r = numbers.length - 1;
		while (l < r) {
			int currentSum = numbers[l] + numbers[r];
			if (currentSum < target) {
				l++;
			} else if (currentSum > target) {
				r--;
			} else if (currentSum == target) {
				return new int[] { l + 1, r + 1 };
			}
		}
		return new int[] {};

	}

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;

		System.out.println(Arrays.toString(new _2_167_Two_Sum_II().twoSum(numbers, target)));
		// Output: [1,2]

		numbers = new int[] { 2, 3, 4 };
		target = 6;

		System.out.println(Arrays.toString(new _2_167_Two_Sum_II().twoSum(numbers, target)));
		// Output: [1,3]

		numbers = new int[] { -1, 0 };
		target = -1;

		System.out.println(Arrays.toString(new _2_167_Two_Sum_II().twoSum(numbers, target)));
		// Output: [1,2]
	}

}
