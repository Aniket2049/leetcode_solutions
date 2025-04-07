package neetcode150.math;

// https://leetcode.com/problems/rotate-image/
// https://www.youtube.com/watch?v=fMSJSS7eO1w
// https://www.youtube.com/watch?v=Ux058jpRB9Y
public class _1_48_RotateImage {
	public void rotate(int[][] matrix) {
		// Reverse the matrix vertically
		reverse(matrix);

		// Transpose the matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private void reverse(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			int[] temp = matrix[i];
			matrix[i] = matrix[n - 1 - i];
			matrix[n - 1 - i] = temp;
		}
	}
}
