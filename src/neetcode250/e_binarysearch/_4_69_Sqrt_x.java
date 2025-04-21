package neetcode250.e_binarysearch;

// https://leetcode.com/problems/sqrtx/
// https://www.youtube.com/watch?v=zdMhGxRWutQ
public class _4_69_Sqrt_x {
	public int mySqrt(int x) {
		int l = 0, r = x;
		int res = 0;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if ((long) m * m > x) {
				r = m - 1;
			} else if ((long) m * m < x) {
				l = m + 1;
				res = m;
			} else {
				return m;
			}
		}

		return res;
	}
}
