package neetcode250.n_2Ddp;

// https://leetcode.com/problems/unique-paths-ii/
// https://www.youtube.com/watch?v=d3UOz7zdE4I
public class _02_63_UniquePathsII {
	public int uniquePathsWithObstacles(int[][] grid) {
		int M = grid.length, N = grid[0].length;
		int[] dp = new int[N + 1];
		dp[N - 1] = 1;

		for (int r = M - 1; r >= 0; r--) {
			for (int c = N - 1; c >= 0; c--) {
				if (grid[r][c] == 1) {
					dp[c] = 0;
				} else {
					dp[c] += dp[c + 1];
				}
			}
		}

		return dp[0];
	}
}
