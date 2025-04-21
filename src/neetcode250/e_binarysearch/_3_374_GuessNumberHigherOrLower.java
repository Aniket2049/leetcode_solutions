package neetcode250.e_binarysearch;

// https://leetcode.com/problems/guess-number-higher-or-lower/
// https://www.youtube.com/watch?v=xW4QsTtaCa4
public class _3_374_GuessNumberHigherOrLower {
	/*
	class Solution extends GuessGame {
		public int guessNumber(int n) {
			int l = 1, r = n;
			while (true) {
				int m = l + (r - l) / 2;
				int res = guess(m);
				if (res > 0) {
					l = m + 1;
				} else if (res < 0) {
					r = m - 1;
				} else {
					return m;
				}
			}
		}
	}
	*/
}
