package neetcode250.i_backtracking;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/n-queens-ii/
// https://www.youtube.com/watch?v=nalYyLZgvCY
public class _15_52_N_QueensII {
	Set<Integer> col = new HashSet<>();
	Set<Integer> posDiag = new HashSet<>();
	Set<Integer> negDiag = new HashSet<>();
	int res;

	public int totalNQueens(int n) {
		res = 0;
		backtrack(0, n);
		return res;
	}

	private void backtrack(int r, int n) {
		if (r == n) {
			res++;
			return;
		}

		for (int c = 0; c < n; c++) {
			if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
				continue;
			}

			col.add(c);
			posDiag.add(r + c);
			negDiag.add(r - c);

			backtrack(r + 1, n);

			col.remove(c);
			posDiag.remove(r + c);
			negDiag.remove(r - c);
		}
	}
}
