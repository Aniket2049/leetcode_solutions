package neetcode250.i_backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
// https://www.youtube.com/watch?v=q0s6m7AiM7o
public class _05_77_Combinations {
	private List<List<Integer>> res;

	public List<List<Integer>> combine(int n, int k) {
		res = new ArrayList<>();
		backtrack(1, n, k, new ArrayList<>());
		return res;
	}

	private void backtrack(int start, int n, int k, List<Integer> comb) {
		if (comb.size() == k) {
			res.add(new ArrayList<>(comb));
			return;
		}

		for (int i = start; i <= n; i++) {
			comb.add(i);
			backtrack(i + 1, n, k, comb);
			comb.remove(comb.size() - 1);
		}
	}
}
