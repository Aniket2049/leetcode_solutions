package neetcode250.n_2Ddp;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/
// https://www.youtube.com/watch?v=IlEsdxuD4lY
public class _01_62_UniquePaths {
	public int uniquePaths(int m, int n) {
		int[] row = new int[n];
		Arrays.fill(row, 1);

		for (int i = 0; i < m - 1; i++) {
			int[] newRow = new int[n];
			Arrays.fill(newRow, 1);
			for (int j = n - 2; j >= 0; j--) {
				newRow[j] = newRow[j + 1] + row[j];
			}
			row = newRow;
		}
		return row[0];
	}
}
