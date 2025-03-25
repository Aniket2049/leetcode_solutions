package neetcode.dynamic2d;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/
// https://www.youtube.com/watch?v=Mjy4hd2xgrs
// https://www.youtube.com/watch?app=desktop&v=HhSZQkdJZok
public class _4_518_CoinChangeII {

	public int change(int amount, int[] coins) {
		Arrays.sort(coins);
		int[][] memo = new int[coins.length + 1][amount + 1];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}

		return dfs(0, amount, coins, memo);
	}

	private int dfs(int i, int a, int[] coins, int[][] memo) {
		if (a == 0)
			return 1;
		if (i >= coins.length)
			return 0;
		if (memo[i][a] != -1)
			return memo[i][a];

		int res = 0;
		if (a >= coins[i]) {
			res = dfs(i + 1, a, coins, memo);
			res += dfs(i, a - coins[i], coins, memo);
		}
		memo[i][a] = res;
		return res;
	}

}
