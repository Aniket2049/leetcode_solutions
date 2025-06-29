package neetcode250.m_1Ddp;

// https://leetcode.com/problems/climbing-stairs/
// https://www.youtube.com/watch?v=UUaMrNOvSqg
public class _01_70_ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 1)
			return 1;

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}
