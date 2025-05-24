package neetcode250.i_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
// https://www.youtube.com/watch?v=FOyRpNUSFeA
public class _04_40_CombinationSumII {
	private List<List<Integer>> res;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		res = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<>(), 0);
		return res;
	}

	private void dfs(int[] candidates, int target, int i, List<Integer> cur, int total) {
		if (total == target) {
			res.add(new ArrayList<>(cur));
			return;
		}
		if (total > target || i == candidates.length) {
			return;
		}

		cur.add(candidates[i]);
		dfs(candidates, target, i + 1, cur, total + candidates[i]);
		cur.remove(cur.size() - 1);

		while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
			i++;
		}
		dfs(candidates, target, i + 1, cur, total);
	}
}
