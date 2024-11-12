package tuf.arrays3;

// https://leetcode.com/problems/search-a-2d-matrix/description/
// https://www.youtube.com/watch?v=JXU4Akft7yk
public class _74_Search_a_2D_Matrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length; // n
		int cols = matrix[0].length; // m
		int low = 0;
		int high = (rows * cols) - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int row = mid / cols;
			int col = mid % cols;
			int midVal = matrix[row][col];

			if (midVal == target)
				return true;
			else if (midVal < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return false;
	}

	public static void main(String[] args) {
//		Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//		Output: true
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;
		System.out.println(new _74_Search_a_2D_Matrix().searchMatrix(matrix, target));

//		Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//		Output: false
		matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		target = 13;
		System.out.println(new _74_Search_a_2D_Matrix().searchMatrix(matrix, target));

		matrix = new int[][] { { 1 } };
		target = 2;
		System.out.println(new _74_Search_a_2D_Matrix().searchMatrix(matrix, target));
	}

}
