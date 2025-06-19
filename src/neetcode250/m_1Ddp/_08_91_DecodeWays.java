package neetcode250.m_1Ddp;

// https://leetcode.com/problems/decode-ways/
// https://www.youtube.com/watch?v=FEkZxCl_-ik
public class _08_91_DecodeWays {
	public int numDecodings(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i <= n; i++) {
			int oneDigit = Integer.valueOf(s.substring(i - 1, i));
			int twoDigits = Integer.valueOf(s.substring(i - 2, i));

			if (oneDigit >= 1)
				dp[i] += dp[i - 1];

			if (twoDigits >= 10 && twoDigits <= 26)
				dp[i] += dp[i - 2];
		}

		return dp[n];
	}
}
