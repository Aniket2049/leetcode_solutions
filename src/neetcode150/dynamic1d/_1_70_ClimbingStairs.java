package neetcode150.dynamic1d;

// https://leetcode.com/problems/climbing-stairs/
// https://www.youtube.com/watch?v=UUaMrNOvSqg
// https://www.youtube.com/watch?v=Y0lT9Fck7qI
// https://neetcode.io/solutions/climbing-stairs
// https://www.youtube.com/shorts/tcD86Ap8vK4
public class _1_70_ClimbingStairs {

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

	public int climbStairsOptimized(int n) {
		int one = 1, two = 1;

		for (int i = 0; i < n - 1; i++) {
			int temp = one;
			one = one + two;
			two = temp;
		}

		return one;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
