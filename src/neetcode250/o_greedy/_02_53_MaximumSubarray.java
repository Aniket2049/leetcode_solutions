package neetcode250.o_greedy;

// https://leetcode.com/problems/maximum-subarray/
// https://www.youtube.com/watch?v=5WZl3MMT0Eg
public class _02_53_MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int maxSub = nums[0], curSum = 0;
		for (int num : nums) {
			if (curSum < 0) {
				curSum = 0;
			}
			curSum += num;
			maxSub = Math.max(maxSub, curSum);
		}
		return maxSub;
	}
}
