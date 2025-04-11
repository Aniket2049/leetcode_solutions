package neetcode250.a_arrays;

// https://leetcode.com/problems/product-of-array-except-self/
// https://www.youtube.com/watch?v=G9zKmhybKBM
public class _16_238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		right[nums.length - 1] = 1;
		for (int i = nums.length - 2; i > -1; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ans[i] = left[i] * right[i];
		}

		return ans;
	}
}
