package neetcode.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/
// https://www.youtube.com/watch?v=Ber2pi2C0j0
public class _2_74_SearchA2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		int potentialRow = -1;

		for (int i = 0; i < matrix.length; i++) {
			int[] currentRow = matrix[i];

			if (currentRow[0] <= target && target <= currentRow[currentRow.length - 1]) {
				potentialRow = i;
				break;
			}
		}

		if (potentialRow == -1)
			return false;

		int[] rowToBeSearched = matrix[potentialRow];
		int l = 0, r = rowToBeSearched.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (rowToBeSearched[m] == target)
				return true;
			else if (target < rowToBeSearched[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;

		System.out.println(new _2_74_SearchA2DMatrix().searchMatrix(matrix, target));

		matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		target = 13;

		System.out.println(new _2_74_SearchA2DMatrix().searchMatrix(matrix, target));

	}

}
