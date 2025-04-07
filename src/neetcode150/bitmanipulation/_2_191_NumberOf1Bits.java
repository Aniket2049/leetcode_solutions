package neetcode150.bitmanipulation;

// https://leetcode.com/problems/number-of-1-bits/
// https://www.youtube.com/watch?v=5Km3utixwZs
// https://algo.monster/liteproblems/191
public class _2_191_NumberOf1Bits {
	public int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
			n &= n - 1;
			res++;
		}
		return res;
	}
}
