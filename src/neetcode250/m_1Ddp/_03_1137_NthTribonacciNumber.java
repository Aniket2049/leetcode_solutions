package neetcode250.m_1Ddp;

// https://leetcode.com/problems/n-th-tribonacci-number/
// https://www.youtube.com/watch?v=3lpNp5Ojvrw
public class _03_1137_NthTribonacciNumber {
	public int tribonacci(int n) {
		if (n <= 2) {
			return n == 0 ? 0 : 1;
		}

		int[] dp = new int[n + 1];
		dp[1] = dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}
}
