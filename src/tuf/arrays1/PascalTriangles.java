package tuf.arrays1;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
// https://www.youtube.com/watch?v=bR7mQgwQ_o8
public class PascalTriangles {

	public static long nCr(int n, int r) {
		long res = 1;

		// calculating nCr:
		for (int i = 0; i < r; i++) {
			res = res * (n - i);
			res = res / (i + 1);
		}
		return res;
	}

	public static int pascalTriangleElementAt(int r, int c) {
		int element = (int) nCr(r - 1, c - 1);
		return element;
	}

	public static void pascalTriangleRow(int n) {
		// printing the entire row n:
		for (int c = 1; c <= n; c++) {
			System.out.print(nCr(n - 1, c - 1) + " ");
		}
		System.out.println();
	}

	public static List<Integer> generateRow(int row) {
		long ans = 1;
		List<Integer> ansRow = new ArrayList<>();
		ansRow.add(1); // inserting the 1st element

		// calculate the rest of the elements:
		for (int col = 1; col < row; col++) {
			ans = ans * (row - col);
			ans = ans / col;
			ansRow.add((int) ans);
		}
		return ansRow;
	}

	public static List<List<Integer>> pascalTriangle(int n) {
		List<List<Integer>> ans = new ArrayList<>();

		// store the entire pascal's triangle:
		for (int row = 1; row <= n; row++) {
			ans.add(generateRow(row));
		}
		return ans;
	}

	public static void main(String[] args) {
		// VARIATION 1
		// In this case, we are given the row number r and the column number c,
		// and we need to find out the element at position (r,c).
		int r = 5; // row number
		int c = 3; // col number
		int element = pascalTriangleElementAt(r, c);
		System.out.println("The element at position (" + r + "," + c + ") is: " + element);

		// VARIATION 2
		// Given the row number n. Print the n-th row of Pascal’s triangle.
		int n = 5;
		System.out.println("\nPascal Triangle row " + n);
		pascalTriangleRow(n);

		// VARITATION 3
		// Print pascals triangle up until given row
		int numOfRows = 7;
		System.out.println("\nPascal Triangle till row " + numOfRows);
		List<List<Integer>> ans = pascalTriangle(numOfRows);
		for (List<Integer> it : ans) {
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

	}

}
