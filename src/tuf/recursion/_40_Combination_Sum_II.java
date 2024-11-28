package tuf.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/description/
// https://www.youtube.com/watch?v=G1fRTGRxXU8
public class _40_Combination_Sum_II {

	static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
		if (target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = ind; i < arr.length; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target)
				break;

			ds.add(arr[i]);
			findCombinations(i + 1, arr, target - arr[i], ans, ds);
			ds.remove(ds.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: candidates = [10,1,2,7,6,1,5], target = 8
//		Output: 
//		[
//		[1,1,6],
//		[1,2,5],
//		[1,7],
//		[2,6]
//		]
		utility.Print.printIntListOfLists(
				new _40_Combination_Sum_II().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));

//		Example 2:
//		Input: candidates = [2,5,2,1,2], target = 5
//		Output: 
//		[
//		[1,2,2],
//		[5]
//		]
		utility.Print.printIntListOfLists(new _40_Combination_Sum_II().combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));

	}

}
