package neetcode150.b_twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
// https://www.youtube.com/watch?v=jzZsG8n2R9A
public class _3_15_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			int currentVal = nums[i];
			if (i > 0 && currentVal == nums[i - 1])
				continue;

			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int threesum = currentVal + nums[l] + nums[r];

				if (threesum > 0)
					r--;
				else if (threesum < 0)
					l++;
				else {
					List<Integer> combination = new ArrayList<Integer>();
					combination.add(currentVal);
					combination.add(nums[l]);
					combination.add(nums[r]);
					result.add(combination);
					l++;
					while (nums[l] == nums[l - 1] && l < r) {
						l++;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] data = new int[] { -1, 0, 1, 2, -1, -4 };
		// [[-1,-1,2],[-1,0,1]]
		List<List<Integer>> res = new _3_15_3Sum().threeSum(data);
		printListOfLists(res);
	}

	public static void printListOfLists(List<List<Integer>> lol) {
		for (int i = 0; i < lol.size(); i++) {
			List<Integer> current = lol.get(i);
			System.out.println("\nList " + (i + 1));
			for (int j = 0; j < current.size(); j++) {
				System.out.print(current.get(j) + " ");
			}
		}
	}

}
