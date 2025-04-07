package tuf_sde.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/
// https://www.youtube.com/watch?v=OyZFFqQtu98
public class _39_Combination_Sum {

	private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
		if (ind == arr.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if (arr[ind] <= target) {
			ds.add(arr[ind]);
			findCombinations(ind, arr, target - arr[ind], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinations(ind + 1, arr, target, ans, ds);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: candidates = [2,3,6,7], target = 7
//		Output: [[2,2,3],[7]]
//		Explanation:
//		2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//		7 is a candidate, and 7 = 7.
//		These are the only two combinations.
		utility.Print.printIntListOfLists(new _39_Combination_Sum().combinationSum(new int[] { 2, 3, 6, 7 }, 7));

//		Example 2:
//		Input: candidates = [2,3,5], target = 8
//		Output: [[2,2,2,2],[2,3,3],[3,5]]
		utility.Print.printIntListOfLists(new _39_Combination_Sum().combinationSum(new int[] { 2, 3, 5 }, 8));

//		Example 3:
//		Input: candidates = [2], target = 1
//		Output: []
		utility.Print.printIntListOfLists(new _39_Combination_Sum().combinationSum(new int[] { 2 }, 1));

	}

}
