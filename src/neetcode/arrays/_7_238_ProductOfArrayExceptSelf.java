package neetcode.arrays;

// https://leetcode.com/problems/product-of-array-except-self/description/
// https://www.youtube.com/watch?v=bNvIQI2wAjk
// https://www.youtube.com/watch?v=G9zKmhybKBM
public class _7_238_ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int[] arr = new int[nums.length];
		int right = 1, left = 1;
		for (int i = 0; i < nums.length; i++) {
			arr[i] = left;
			left *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			arr[i] *= right;
			right *= nums[i];
		}

		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
		System.out.print("]\n");

		return arr;
	}

	public int[] productExceptSelf2(int[] nums) {

		// Array to store all left multiplication
		int[] left = new int[nums.length];

		// Array to store all right multiplication
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

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,2,3,4]
//		Output: [24,12,8,6]
		new _7_238_ProductOfArrayExceptSelf().productExceptSelf(new int[] { 1, 2, 3, 4 });
//		Example 2:
//		Input: nums = [-1,1,0,-3,3]
//		Output: [0,0,9,0,0]
		new _7_238_ProductOfArrayExceptSelf().productExceptSelf(new int[] { -1, 1, 0, -3, 3 });

	}

}
