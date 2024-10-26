package tuf.arrays1;

// https://leetcode.com/problems/set-matrix-zeroes/description/
// https://www.youtube.com/watch?v=T41rL0L3Pnw
public class _73_SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean rowZero = false;

		// marking first row and column
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (matrix[r][c] == 0) {
					matrix[0][c] = 0;

					if (r > 0)
						matrix[r][0] = 0;
					else
						rowZero = true;

				}
			}
		}

		// reading from first row and column+rowZero and setting entire row col to 0
		for (int r = 1; r < rows; r++) {
			for (int c = 1; c < cols; c++) {
				if (matrix[0][c] == 0 || matrix[r][0] == 0) {
					matrix[r][c] = 0;
				}
			}
		}

		// setting first col to zero
		if (matrix[0][0] == 0) {
			for (int r = 0; r < rows; r++) {
				matrix[r][0] = 0;
			}
		}

		// setting first row to zero
		if (rowZero) {
			for (int c = 0; c < cols; c++) {
				matrix[0][c] = 0;
			}
		}

		// print solution
		System.out.print("[");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == matrix[0].length - 1)
					System.out.print(matrix[i][j] + "");
				else
					System.out.print(matrix[i][j] + ",");
			}
			if (i == matrix.length - 1) {
				System.out.print("]");
			} else {
				System.out.print("],");
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		// Output: [[1,0,1],[0,0,0],[1,0,1]]

		_73_SetMatrixZeroes obj = new _73_SetMatrixZeroes();
		obj.setZeroes(matrix);
	}

}