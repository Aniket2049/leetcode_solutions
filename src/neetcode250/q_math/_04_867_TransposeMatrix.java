package neetcode250.q_math;

// https://leetcode.com/problems/transpose-matrix/
// https://www.youtube.com/watch?v=DzMT3bDgVn0
public class _04_867_TransposeMatrix {
	public int[][] transpose(int[][] matrix) {
		int ROWS = matrix.length, COLS = matrix[0].length;
		int[][] res = new int[COLS][ROWS];

		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				res[c][r] = matrix[r][c];
			}
		}

		return res;
	}
}
