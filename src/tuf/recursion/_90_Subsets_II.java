package tuf.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/description/
// https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/
// https://www.youtube.com/watch?v=qGyyzpNlMDU
public class _90_Subsets_II {

	private static void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {
// If the set is already present, just continue
		if (resultSets.contains((tempSet)))
			return;

		resultSets.add(new ArrayList<>(tempSet));

		for (int i = start; i < nums.length; i++) {
// Case of including the number
			tempSet.add(nums[i]);

// Backtrack the new subset
			backtrack(resultSets, tempSet, nums, i + 1);

// Case of not-including the number
			tempSet.remove(tempSet.size() - 1);
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		Arrays.sort(nums);

		// Start backtracking from the beginning
		backtrack(resultList, new ArrayList<>(), nums, 0);
		return resultList;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,2,2]
//		Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

//		Example 2:
//		Input: nums = [0]
//		Output: [[],[0]]

		int nums[] = { 1, 2, 2 };
		List<List<Integer>> ans = subsetsWithDup(nums);
		System.out.println(ans.toString().replace(",", " "));

	}

}
