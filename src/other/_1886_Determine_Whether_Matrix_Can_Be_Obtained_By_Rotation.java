package other;

import java.util.Arrays;

// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
public class _1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {

	public int[][] rotate(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			int m = matrix[i].length; // col length
			for (int j = 0; j < m / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][m - j - 1];
				matrix[i][m - j - 1] = temp;
			}
		}

		return matrix;
	}

	public boolean findRotation(int[][] mat, int[][] target) {

		if (Arrays.deepToString(mat).equals(Arrays.deepToString(target)))
			return true;

		int[][] rotatedMatrix = mat;
		for (int i = 1; i <= 3; i++) {
			rotatedMatrix = rotate(mat);
			String rotatedMatrixStr = Arrays.deepToString(rotatedMatrix);
			String targetMatrixStr = Arrays.deepToString(target);

			if (rotatedMatrixStr.equals(targetMatrixStr))
				return true;
		}

		return false;

	}

	public static void main(String[] args) {
//		Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
//		Output: true

		int[][] mat1 = { { 0, 1 }, { 1, 0 } };
		int[][] target1 = { { 1, 0 }, { 0, 1 } };
		System.out
				.println(new _1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation().findRotation(mat1, target1));

//		Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
//		Output: false

		int[][] mat2 = { { 0, 1 }, { 1, 1 } };
		int[][] target2 = { { 1, 0 }, { 0, 1 } };
		System.out
				.println(new _1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation().findRotation(mat2, target2));

//		Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
//		Output: true

		int[][] mat3 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] target3 = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out
				.println(new _1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation().findRotation(mat3, target3));
	}

}
