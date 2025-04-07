package tuf_sde.recursionbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/n-queens/
// https://www.youtube.com/watch?v=Ph95IHmRp5M
// https://neetcode.io/solutions/n-queens
public class _51_NQueens {

	Set<Integer> col = new HashSet<>();
	Set<Integer> posDiag = new HashSet<>();
	Set<Integer> negDiag = new HashSet<>();
	List<List<String>> res = new ArrayList<>();

	private void backtrack(int r, int n, char[][] board) {
		if (r == n) {
			List<String> copy = new ArrayList<>();
			for (char[] row : board) {
				copy.add(new String(row));
			}
			res.add(copy);
			return;
		}

		for (int c = 0; c < n; c++) {
			if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
				continue;
			}

			col.add(c);
			posDiag.add(r + c);
			negDiag.add(r - c);
			board[r][c] = 'Q';

			backtrack(r + 1, n, board);

			col.remove(c);
			posDiag.remove(r + c);
			negDiag.remove(r - c);
			board[r][c] = '.';
		}
	}

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (char[] row : board) {
			Arrays.fill(row, '.');
		}

		backtrack(0, n, board);
		return res;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: n = 4
//		Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//		Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
		utility.Print.printStringListOfLists(new _51_NQueens().solveNQueens(4));

//		Example 2:
//		Input: n = 1
//		Output: [["Q"]]
		utility.Print.printStringListOfLists(new _51_NQueens().solveNQueens(1));

	}

}
