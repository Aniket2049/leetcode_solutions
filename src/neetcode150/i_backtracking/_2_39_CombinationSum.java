package neetcode150.i_backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum
// https://www.youtube.com/watch?v=GBKI9VSKdGg
public class _2_39_CombinationSum {

	List<List<Integer>> res;

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		backtrack(nums, target, cur, 0);
		return res;
	}

	public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		if (target < 0 || i >= nums.length) {
			return;
		}

		cur.add(nums[i]);
		backtrack(nums, target - nums[i], cur, i);
		cur.remove(cur.size() - 1);
		backtrack(nums, target, cur, i + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
