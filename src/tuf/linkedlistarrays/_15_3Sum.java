package tuf.linkedlistarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
// https://www.youtube.com/watch?v=DhFh8Kw7ymk
public class _15_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			// remove duplicates:
			if (i != 0 && nums[i] == nums[i - 1])
				continue;

			// moving 2 pointers:
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
					ans.add(temp);
					j++;
					k--;
					// skip the duplicates:
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [-1,0,1,2,-1,-4]
//		Output: [[-1,-1,2],[-1,0,1]]
//		Explanation: 
//		nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//		nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//		nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//		The distinct triplets are [-1,0,1] and [-1,-1,2].
//		Notice that the order of the output and the order of the triplets does not matter.
		utility.Print.printIntListOfLists(new _15_3Sum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));

//		Example 2:
//		Input: nums = [0,1,1]
//		Output: []
//		Explanation: The only possible triplet does not sum up to 0.
		utility.Print.printIntListOfLists(new _15_3Sum().threeSum(new int[] { 0, 1, 1 }));

//		Example 3:
//		Input: nums = [0,0,0]
//		Output: [[0,0,0]]
//		Explanation: The only possible triplet sums up to 0.
		utility.Print.printIntListOfLists(new _15_3Sum().threeSum(new int[] { 0, 0, 0 }));

	}

}
