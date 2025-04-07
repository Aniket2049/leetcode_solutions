package tuf_sde.arrays2;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/description/
// https://www.youtube.com/watch?v=P1Ic85RarKY
// https://leetcode.com/problems/merge-sorted-array/solutions/6025959/beginner-friendly-step-by-steps-solution-beats-100-user-in-each-solution-of-me/
public class _88_Merge_Sorted_Array {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			int arr1El = nums1[i];
			int arr2El = nums2[j];
			int arr1LastIndex = k;
			if (arr1El > arr2El) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}

		System.out.println(Arrays.toString(nums1));
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//		Output: [1,2,2,3,5,6]
//		Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//		The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = new int[] { 2, 5, 6 };
		int n = 3;

		new _88_Merge_Sorted_Array().merge(nums1, m, nums2, n);

//		Example 2:
//		Input: nums1 = [1], m = 1, nums2 = [], n = 0
//		Output: [1]
//		Explanation: The arrays we are merging are [1] and [].
//		The result of the merge is [1].

		nums1 = new int[] { 1 };
		m = 1;
		nums2 = new int[] {};
		n = 0;

		new _88_Merge_Sorted_Array().merge(nums1, m, nums2, n);

//		Example 3:
//		Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//		Output: [1]
//		Explanation: The arrays we are merging are [] and [1].
//		The result of the merge is [1].
//		Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

		nums1 = new int[] { 0 };
		m = 0;
		nums2 = new int[] { 1 };
		n = 1;

		new _88_Merge_Sorted_Array().merge(nums1, m, nums2, n);

		nums1 = new int[] { 2, 0 };
		m = 1;
		nums2 = new int[] { 1 };
		n = 1;

		new _88_Merge_Sorted_Array().merge(nums1, m, nums2, n);

		nums1 = new int[] { -1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0 };
		m = 5;
		nums2 = new int[] { -1, -1, 0, 0, 1, 2 };
		n = 6;

		new _88_Merge_Sorted_Array().merge(nums1, m, nums2, n);

	}

}
