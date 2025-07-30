package neetcode250.r_bitmanipulation;

// https://leetcode.com/problems/minimum-array-end/
// https://www.youtube.com/watch?v=rChLZzzggjo
public class _10_3133_MinimumArrayEnd {
	public long minEnd(int n, int x) {
		long num = x;

		for (int i = 1; i < n; i++) {
			num = (num + 1) | x;
		}

		return num;
	}
}
