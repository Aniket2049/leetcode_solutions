package neetcode250.m_1Ddp;

import java.util.Arrays;

// https://leetcode.com/problems/perfect-squares/
// https://www.youtube.com/watch?v=HLZLwjzIVGo
public class _15_279_PerfectSquares {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n);
		dp[0] = 0;

		for (int target = 1; target <= n; target++) {
			for (int s = 1; s * s <= target; s++) {
				dp[target] = Math.min(dp[target], 1 + dp[target - s * s]);
			}
		}

		return dp[n];
	}
}
