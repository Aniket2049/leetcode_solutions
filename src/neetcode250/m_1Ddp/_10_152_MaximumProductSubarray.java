package neetcode250.m_1Ddp;

// https://leetcode.com/problems/maximum-product-subarray/
// https://www.youtube.com/watch?v=Y6B-7ZctiW8
public class _10_152_MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int n = nums.length;
		long leftProduct = 1;
		long rightProduct = 1;
		long ans = nums[0];

		for (int i = 0; i < n; i++) {

			//if any of leftProduct or rightProduct become 0 then update it to 1
			leftProduct = (leftProduct == 0 || leftProduct < Integer.MIN_VALUE) ? 1 : leftProduct;
			rightProduct = (rightProduct == 0 || rightProduct < Integer.MIN_VALUE) ? 1 : rightProduct;

			//prefix product
			leftProduct *= nums[i];

			//suffix product
			rightProduct *= nums[n - 1 - i];

			ans = Math.max(ans, Math.max(leftProduct, rightProduct));
		}

		return (int) ans;
	}
}
