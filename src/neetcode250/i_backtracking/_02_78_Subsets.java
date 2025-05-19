package neetcode250.i_backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
// https://www.youtube.com/watch?v=REOH22Xwdkk
public class _02_78_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		dfs(nums, 0, subset, res);
		return res;
	}

	private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
		if (i >= nums.length) {
			res.add(new ArrayList<>(subset));
			return;
		}
		subset.add(nums[i]);
		dfs(nums, i + 1, subset, res);
		subset.remove(subset.size() - 1);
		dfs(nums, i + 1, subset, res);
	}
}
