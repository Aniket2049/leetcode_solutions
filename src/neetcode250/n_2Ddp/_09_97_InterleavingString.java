package neetcode250.n_2Ddp;

// https://leetcode.com/problems/interleaving-string/
// https://www.youtube.com/watch?v=3Rw3p9LrgvE
public class _09_97_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length(), n = s2.length();
		if (m + n != s3.length()) {
			return false;
		}

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[m][n] = true;

		for (int i = m; i >= 0; i--) {
			for (int j = n; j >= 0; j--) {
				if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
					dp[i][j] = true;
				}
				if (j < n && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
					dp[i][j] = true;
				}
			}
		}
		return dp[0][0];
	}
}
