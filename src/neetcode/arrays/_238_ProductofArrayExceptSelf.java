package neetcode.arrays;

// https://leetcode.com/problems/product-of-array-except-self/description/
// https://www.youtube.com/watch?v=bNvIQI2wAjk
public class _238_ProductofArrayExceptSelf {

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

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,2,3,4]
//		Output: [24,12,8,6]
		new _238_ProductofArrayExceptSelf().productExceptSelf(new int[] {1,2,3,4});
//		Example 2:
//		Input: nums = [-1,1,0,-3,3]
//		Output: [0,0,9,0,0]
		new _238_ProductofArrayExceptSelf().productExceptSelf(new int[] {-1,1,0,-3,3});

	}

}
