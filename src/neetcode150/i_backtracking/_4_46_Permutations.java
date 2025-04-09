package neetcode150.i_backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations
// https://www.youtube.com/watch?v=H232aocj7bQ
public class _4_46_Permutations {

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> resultList = new ArrayList<>();

		backtrack(resultList, new ArrayList<>(), nums);
		return resultList;
	}

	private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums) {
		// If we match the length, it is a permutation
		if (tempList.size() == nums.length) {
			resultList.add(new ArrayList<>(tempList));
			return;
		}

		for (int number : nums) {
			// Skip if we get same element
			if (tempList.contains(number))
				continue;

			// Add the new element
			tempList.add(number);

			// Go back to try other element
			backtrack(resultList, tempList, nums);

			// Remove the element
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
