package neetcode250.b_twopointers;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// https://www.youtube.com/watch?v=cQ1Oz4ckceM
public class _7_167_TwoSumII_InputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
		int l = 0;
		int r = numbers.length - 1;

		while (l < r) {
			int currentSum = numbers[l] + numbers[r];
			if (currentSum == target) {
				return new int[] { l + 1, r + 1 };
			} else if (currentSum < target) {
				l++;
			} else {
				r--;
			}
		}

		return new int[] {};
	}

}
