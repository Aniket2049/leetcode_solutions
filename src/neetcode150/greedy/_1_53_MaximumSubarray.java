package neetcode150.greedy;

// https://leetcode.com/problems/maximum-subarray/description/
// https://www.youtube.com/watch?v=GrNSGC8Z2T0
public class _1_53_MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max_so_far = nums[0];
		int curr_max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			curr_max = Math.max(nums[i], nums[i] + curr_max);
			max_so_far = Math.max(curr_max, max_so_far);
		}

		return max_so_far;
	}
}
