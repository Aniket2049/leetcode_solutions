package neetcode250.r_bitmanipulation;

// https://leetcode.com/problems/number-of-1-bits/
// https://www.youtube.com/watch?v=5Km3utixwZs
public class _02_191_NumberOf1Bits {
	public int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
			res += (n & 1) == 1 ? 1 : 0;
			n >>= 1;
		}
		return res;
	}
}
