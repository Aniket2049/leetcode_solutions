package neetcode250.m_1Ddp;

import java.util.Arrays;

// https://leetcode.com/problems/integer-break/
// https://www.youtube.com/watch?v=iXtqfIrWMZg
public class _16_343_IntegerBreak {
	private int[] t;

	public int solve(int n) {
		if (n == 1)
			return 1;

		if (t[n] != -1)
			return t[n];

		int result = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			int prod = i * Math.max(n - i, solve(n - i));
			result = Math.max(result, prod);
		}

		return t[n] = result;
	}

	public int integerBreak(int n) {
		t = new int[59];
		Arrays.fill(t, -1);
		return solve(n);
	}
}
