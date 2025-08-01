package neetcode250.o_greedy;

// https://leetcode.com/problems/maximum-sum-circular-subarray/
// https://www.youtube.com/watch?v=fxT9KjakYPM
public class _03_918_MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] nums) {
		int globMax = nums[0], globMin = nums[0];
		int curMax = 0, curMin = 0, total = 0;

		for (int num : nums) {
			curMax = Math.max(curMax + num, num);
			curMin = Math.min(curMin + num, num);
			total += num;
			globMax = Math.max(globMax, curMax);
			globMin = Math.min(globMin, curMin);
		}

		return globMax > 0 ? Math.max(globMax, total - globMin) : globMax;
	}
}
