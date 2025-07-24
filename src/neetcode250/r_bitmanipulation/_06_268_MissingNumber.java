package neetcode250.r_bitmanipulation;

// https://leetcode.com/problems/missing-number/
// https://www.youtube.com/watch?v=iCrQG_kbuP0
public class _06_268_MissingNumber {
	public int missingNumber(int[] nums) {
		int allXOR = 0;

		// XOR all numbers in range [0, n]
		for (int i = 0; i <= nums.length; i++) {
			allXOR = allXOR ^ i;
		}

		// XOR all numbers in the given array
		for (int num : nums) {
			allXOR = allXOR ^ num;
		}

		// The missing number
		return allXOR;
	}
}
