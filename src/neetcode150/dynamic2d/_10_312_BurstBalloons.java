package neetcode150.dynamic2d;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/burst-balloons/
// https://www.youtube.com/watch?v=VFskby7lUbw
// https://algo.monster/liteproblems/312
// https://www.youtube.com/watch?v=l5AZpRsgcH4
// https://www.youtube.com/watch?v=Yz4LlDSlkns
public class _10_312_BurstBalloons {
	public int maxCoinsBottomUp(int[] nums) {
		int n = nums.length;
		int[] newNums = new int[n + 2];
		newNums[0] = newNums[n + 1] = 1;
		for (int i = 0; i < n; i++) {
			newNums[i + 1] = nums[i];
		}

		int[][] dp = new int[n + 2][n + 2];
		for (int l = n; l >= 1; l--) {
			for (int r = l; r <= n; r++) {
				for (int i = l; i <= r; i++) {
					int coins = newNums[l - 1] * newNums[i] * newNums[r + 1];
					coins += dp[l][i - 1] + dp[i + 1][r];
					dp[l][r] = Math.max(dp[l][r], coins);
				}
			}
		}

		return dp[1][n];
	}

	//---------------------
	// Top Down
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[] newNums = new int[n + 2];
		newNums[0] = newNums[n + 1] = 1;
		for (int i = 0; i < n; i++) {
			newNums[i + 1] = nums[i];
		}

		int[][] dp = new int[n + 2][n + 2];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}

		return dfs(newNums, 1, newNums.length - 2, dp);
	}

	public int dfs(int[] nums, int l, int r, int[][] dp) {
		if (l > r) {
			return 0;
		}
		if (dp[l][r] != -1) {
			return dp[l][r];
		}

		dp[l][r] = 0;
		for (int i = l; i <= r; i++) {
			int coins = nums[l - 1] * nums[i] * nums[r + 1];
			coins += dfs(nums, l, i - 1, dp) + dfs(nums, i + 1, r, dp);
			dp[l][r] = Math.max(dp[l][r], coins);
		}
		return dp[l][r];
	}

	////////////-----TUF

	static int maxCoins(ArrayList<Integer> a) {
		int n = a.size();

		// Add 1 to the beginning and end of the array
		a.add(0, 1);
		a.add(1);

		// Create a 2D DP array
		int[][] dp = new int[n + 2][n + 2];

		// Iterate from the end to the beginning
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n; j++) {
				if (i > j)
					continue;
				int maxi = Integer.MIN_VALUE;

				// Iterate through possible indices to split the array
				for (int ind = i; ind <= j; ind++) {
					int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1) + dp[i][ind - 1] + dp[ind + 1][j];
					maxi = Math.max(maxi, cost);
				}
				dp[i][j] = maxi;
			}
		}
		return dp[1][n];
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 1, 5, 8));
		int ans = maxCoins(a);
		System.out.println(ans);
	}
}
