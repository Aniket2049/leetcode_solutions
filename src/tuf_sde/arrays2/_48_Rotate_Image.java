package tuf_sde.arrays2;

// https://leetcode.com/problems/rotate-image/description/
// https://www.youtube.com/watch?v=Z0R2u6gd3GU
public class _48_Rotate_Image {

	public void rotate(int[][] matrix) {
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

		System.out.print("[");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == matrix[i].length - 1)
					System.out.print(matrix[i][j]);
				else
					System.out.print(matrix[i][j] + ",");
			}
			System.out.print("]");
		}
		System.out.print("]");
		System.out.println();
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//		Output: [[7,4,1],[8,5,2],[9,6,3]]
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new _48_Rotate_Image().rotate(matrix);

//		Example 2:
//		Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//		Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
		matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		new _48_Rotate_Image().rotate(matrix);
	}

}
