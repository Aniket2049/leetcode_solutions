package other;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
// https://www.youtube.com/watch?v=3tpjp5h3M6Y
public class _78_Subsets {

	private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {
// Add the set to result set
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

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();

		// Start backtracking from the beginning
		backtrack(resultList, new ArrayList<>(), nums, 0);
		return resultList;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,2,3]
//		Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
		utility.Print.printIntListOfLists(new _78_Subsets().subsets(new int[] { 1, 2, 3 }));

//		Example 2:
//		Input: nums = [0]
		utility.Print.printIntListOfLists(new _78_Subsets().subsets(new int[] { 0 }));

	}

}
