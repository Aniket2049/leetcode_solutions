package neetcode150.bitmanipulation;

// https://leetcode.com/problems/reverse-bits/
// https://www.youtube.com/watch?v=UcoN6UjAI64
// https://algo.monster/liteproblems/190
public class _4_190_ReverseBits {
	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int bit = (n >> i) & 1;
			res += (bit << (31 - i));
		}
		return res;
	}
}
