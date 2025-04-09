package neetcode150.i_backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
// https://www.youtube.com/watch?v=3tpjp5h3M6Y
public class _1_78_Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void backtrack(List<List<Integer>> resultSet, List<Integer> tempList, int[] nums, int start) {
		resultSet.add(new ArrayList<Integer>(tempList));

		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(resultSet, tempList, nums, i + 1);
			tempList.removeLast();
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		backtrack(resultList, new ArrayList<Integer>(), nums, 0);
		return resultList;
	}

}
