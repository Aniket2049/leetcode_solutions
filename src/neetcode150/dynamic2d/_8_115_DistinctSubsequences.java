package neetcode150.dynamic2d;

import java.util.Arrays;

// https://leetcode.com/problems/distinct-subsequences/
// https://www.youtube.com/watch?v=6ngJWBA-nZk
// https://leetcode.com/problems/distinct-subsequences/solutions/37327/easy-to-understand-dp-in-java/
public class _8_115_DistinctSubsequences {

	Integer[][] cache;
	char[] sArr, tArr;
	int sLen, tLen;

	public int numDistinct(String s, String t) {
		sArr = s.toCharArray();
		tArr = t.toCharArray();
		sLen = sArr.length;
		tLen = tArr.length;

		//Base case 
		if (sLen < tLen)
			return 0;

		cache = new Integer[tLen][sLen];

		return dfs(tLen - 1, sLen - 1);
	}

	private int dfs(int tIndex, int sIndex) {
		//Base case
		if (0 <= sIndex && tIndex < 0)
			return 1;// s="a" t=""
		if (sIndex < 0 && tIndex < 0)
			return 1; //s="" t=""
		if (sIndex < 0 && 0 <= tIndex)
			return 0; // s="" t="a"

		if (cache[tIndex][sIndex] != null)
			return cache[tIndex][sIndex];

		if (sArr[sIndex] == tArr[tIndex]) {
			cache[tIndex][sIndex] = dfs(tIndex - 1, sIndex - 1) + dfs(tIndex, sIndex - 1);
		} else {
			cache[tIndex][sIndex] = dfs(tIndex, sIndex - 1);
		}

		return cache[tIndex][sIndex];
	}

	// Top Down
	//------------------------------------------------
	// Bottom Up
	
	public int numDistinctBottomUp(String s, String t) {
		char[] sArr = s.toCharArray(), tArr = t.toCharArray();
		int sLen = sArr.length, tLen = tArr.length;

		//Base case 
		if (sLen < tLen)
			return 0;

		int[][] cache = new int[tLen + 1][sLen + 1];

		//Build the first row
		Arrays.fill(cache[0], 1);

		for (int row = 1; row <= tLen; row++) {
			for (int col = 1; col <= sLen; col++) {
				if (sArr[col - 1] == tArr[row - 1]) {
					cache[row][col] = cache[row - 1][col - 1] + cache[row][col - 1];
				} else {
					cache[row][col] = cache[row][col - 1];
				}
			}
		}
		return cache[tLen][sLen];
	}
}
