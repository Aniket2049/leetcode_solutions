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

//	[a0,  a1,  a2,    a3,   a4,   a5,  a6, ... an]
//	        ^	                   ^	
//        sumI	                 sumJ
//
//
//	sumI = sum of numbers till a2 (a0 + a1 + a2)
//	sumJ = sum of numbers till a5 (a0 + a1 + a2 + a3 + a4 + a5)
//	
//	
//	Now lets say the difference between sumJ and sumI is equal to k. 
//	What that means is, the sum of numbers between a2 and a5 is equal to k ( a3 + a4 + a5 = k ), which means we found a subarray whose sum is equal to k.
//	
//	We can write a3 + a4 + a5 = k as sumJ - sumI = k and sumJ - sumI = k can be written as sumJ - k = sumI
//	
//	The expression sumJ - k = sumI, means have we already seen a sum which is equal to sum at current index j minus k. If yes, it means we found a subarray whose sum is equal to k.
//	
//	And we keep track of how many times we see a particular sum using a HashMap.
}
