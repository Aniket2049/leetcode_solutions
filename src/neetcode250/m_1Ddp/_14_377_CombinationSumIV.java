package neetcode250.m_1Ddp;

// https://leetcode.com/problems/combination-sum-iv/
// https://www.youtube.com/watch?v=dw2nMCxG0ik
// https://algo.monster/liteproblems/377
public class _14_377_CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {
		// dp represents the number of combinations to make up each value from 0 up to target
		int[] dp = new int[target + 1];

		// There is exactly one combination to make up the target 0, which is to choose nothing
		dp[0] = 1;

		// Iterate over all values from 1 to target to find combinations
		for (int i = 1; i <= target; ++i) {
			// Iterate through all numbers in the given array
			for (int num : nums) {
				// If the number is less than or equal to the current target (i)
				// then we can use it to form a combination
				if (i >= num) {
					// Add the number of combinations from the previous value (i - num) 
					// to the current number of combinations
					dp[i] += dp[i - num];
				}
			}
		}

		// Return the number of combinations to form the target
		return dp[target];
	}
}
