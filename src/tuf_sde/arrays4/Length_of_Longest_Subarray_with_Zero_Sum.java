package tuf_sde.arrays4;

import java.util.HashMap;

// https://leetcode.com/discuss/general-discussion/1042029/find-length-of-the-largest-subarray-with-sum-0
// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
public class Length_of_Longest_Subarray_with_Zero_Sum {

	int maxLen(int arr[]) {
		HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

		int maxi = 0;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				maxi = i + 1;
			} else {
				if (mpp.get(sum) != null) {
					maxi = Math.max(maxi, i - mpp.get(sum));
				} else {
					mpp.put(sum, i);
				}
			}
		}

		return maxi;
	}

	public static void main(String[] args) {
//		Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
//		Output: 5
//		Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
		System.out.println(new Length_of_Longest_Subarray_with_Zero_Sum().maxLen(new int[] { -2, 2, -8, 1, 7 }));

//		Input: arr[] = [2, 10, 4]
//		Output: 0
//		Explanation: There is no subarray with a sum of 0.
		System.out.println(new Length_of_Longest_Subarray_with_Zero_Sum().maxLen(new int[] { 2, 10, 4 }));

//		Input: arr[] = [1, 0, -4, 3, 1, 0]
//		Output: 5
//		Explanation: The subarray is [0, -4, 3, 1, 0].
		System.out.println(new Length_of_Longest_Subarray_with_Zero_Sum().maxLen(new int[] { 1, 0, -4, 3, 1, 0 }));

	}

}
