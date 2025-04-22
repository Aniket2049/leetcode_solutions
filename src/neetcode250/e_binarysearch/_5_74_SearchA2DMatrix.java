package neetcode250.e_binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/description/
// https://www.youtube.com/watch?v=RhPqIIOUiS8
public class _5_74_SearchA2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
				return binarySearch(matrix, i, target);
			} else
				continue;
		}

		return false;
	}

	private boolean binarySearch(int[][] matrix, int i, int target) {
		int[] arrayToCheck = matrix[i];

		int l = 0;
		int r = arrayToCheck.length - 1;
		while (l <= r) {
			int m = l + ((r - l) / 2);

			if (arrayToCheck[m] == target) {
				return true;
			} else if (arrayToCheck[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return false;
	}
}
