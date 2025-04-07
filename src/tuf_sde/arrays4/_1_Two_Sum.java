package tuf_sde.arrays4;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/description/
// 
public class _1_Two_Sum {

	public int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		ans[0] = ans[1] = -1;
		HashMap<Integer, Integer> mpp = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int moreNeeded = target - num;
			if (mpp.containsKey(moreNeeded)) {
				ans[0] = mpp.get(moreNeeded);
				ans[1] = i;
				return ans;
			}

			mpp.put(nums[i], i);
		}
		return ans;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [2,7,11,15], target = 9
//		Output: [0,1]
//		Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
		System.out.println(Arrays.toString(new _1_Two_Sum().twoSum(new int[] { 2, 7, 11, 15 }, 9)));
//		Example 2:
//		Input: nums = [3,2,4], target = 6
//		Output: [1,2]
		System.out.println(Arrays.toString(new _1_Two_Sum().twoSum(new int[] { 3, 2, 4 }, 6)));

//		Example 3:
//		Input: nums = [3,3], target = 6
//		Output: [0,1]
		System.out.println(Arrays.toString(new _1_Two_Sum().twoSum(new int[] { 3, 3 }, 6)));

	}

}
