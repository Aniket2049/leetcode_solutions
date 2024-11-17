package other;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/
// https://www.youtube.com/watch?v=AmlVSNBHzJg
public class _560_Subarray_Sum_Equals_K {

	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> arr_sums = new HashMap<Integer, Integer>();
		arr_sums.put(0, 1);
		int sum = 0;
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (arr_sums.containsKey(sum - k)) {
				result += arr_sums.get(sum - k);
			}

			arr_sums.put(sum, arr_sums.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,1,1], k = 2
//		Output: 2
		System.out.println(new _560_Subarray_Sum_Equals_K().subarraySum(new int[] { 1, 1, 1 }, 2));

//		Example 2:
//		Input: nums = [1,2,3], k = 3
//		Output: 2
		System.out.println(new _560_Subarray_Sum_Equals_K().subarraySum(new int[] { 1, 2, 3 }, 3));
	}

}
