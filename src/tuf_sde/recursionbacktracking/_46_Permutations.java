package tuf_sde.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/description/
// https://www.youtube.com/watch?v=YK78FU5Ffjw
// https://www.youtube.com/watch?v=f2ic2Rsc9pU
public class _46_Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<Integer>();
		boolean[] elementTaken = new boolean[nums.length];
		recurPermute(nums, tempList, answer, elementTaken);
		return answer;
	}

	private void recurPermute(int[] nums, List<Integer> tempList, List<List<Integer>> answer, boolean[] elementTaken) {
		if (tempList.size() == nums.length) {
			answer.add(new ArrayList<Integer>(tempList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!elementTaken[i]) {
				elementTaken[i] = true;
				tempList.add(nums[i]);
				recurPermute(nums, tempList, answer, elementTaken);
				tempList.remove(tempList.size() - 1);
				elementTaken[i] = false;
			}
		}

	}

	public List<List<Integer>> permuteOptimal(int[] nums) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		recurPermuteOptimal(0, nums, answer);
		return answer;
	}

	private void recurPermuteOptimal(int index, int[] nums, List<List<Integer>> answer) {
		if (index == nums.length) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				tempList.add(nums[i]);
			}
			answer.add(tempList);
			return;
		}

		for (int i = index; i < nums.length; i++) {
			swap(i, index, nums);
			recurPermuteOptimal(index + 1, nums, answer);
			swap(i, index, nums);
		}

	}

	private void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;

	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,2,3]
//		Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		utility.Print.printIntListOfLists(new _46_Permutations().permuteOptimal(new int[] { 1, 2, 3 }));

//		Example 2:
//		Input: nums = [0,1]
//		Output: [[0,1],[1,0]]
		utility.Print.printIntListOfLists(new _46_Permutations().permuteOptimal(new int[] { 0, 1 }));

//		Example 3:
//		Input: nums = [1]
//		Output: [[1]]
		utility.Print.printIntListOfLists(new _46_Permutations().permuteOptimal(new int[] { 1 }));

	}

}
