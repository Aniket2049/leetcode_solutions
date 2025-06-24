package neetcode250.n_2Ddp;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/
// https://www.youtube.com/watch?v=Mjy4hd2xgrs
public class _07_518_CoinChangeII {
	public int change(int amount, int[] coins) {
		int n = coins.length;
		Arrays.sort(coins);
		int[][] dp = new int[n + 1][amount + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int a = 0; a <= amount; a++) {
				if (a >= coins[i]) {
					dp[i][a] = dp[i + 1][a];
					dp[i][a] += dp[i][a - coins[i]];
				}
			}
		}

		return dp[0][amount];
	}
}
