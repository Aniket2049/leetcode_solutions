package neetcode250.a_arrays;

// https://leetcode.com/problems/range-sum-query-2d-immutable/
// https://www.youtube.com/watch?v=V449LzeAQGI
// https://www.youtube.com/watch?v=KE8MQuwE2yA
// https://algo.monster/liteproblems/304
public class _15_304_RangeSumQuery2DImmutable {
	class NumMatrix {
		private int[][] prefixMatrix;

		public NumMatrix(int[][] matrix) {
			int ROWS = matrix.length, COLS = matrix[0].length;
			prefixMatrix = new int[ROWS + 1][COLS + 1];

			for (int r = 0; r < ROWS; r++) {
				int prefix = 0;
				for (int c = 0; c < COLS; c++) {
					prefix += matrix[r][c];
					int above = prefixMatrix[r][c + 1];
					prefixMatrix[r + 1][c + 1] = prefix + above;
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			row1++;
			col1++;
			row2++;
			col2++;
			int bottomRight = prefixMatrix[row2][col2];
			int above = prefixMatrix[row1 - 1][col2];
			int left = prefixMatrix[row2][col1 - 1];
			int topLeft = prefixMatrix[row1 - 1][col1 - 1];
			return bottomRight - above - left + topLeft;
		}
	}
}
