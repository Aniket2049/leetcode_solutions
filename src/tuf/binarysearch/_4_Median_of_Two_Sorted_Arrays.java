package tuf.binarysearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// https://www.youtube.com/watch?v=C2rRzz-JDk8
public class _4_Median_of_Two_Sorted_Arrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		// if n1 is bigger swap the arrays:
		if (n1 > n2)
			return findMedianSortedArrays(nums2, nums1);

		int n = n1 + n2; // total length
		int left = (n1 + n2 + 1) / 2; // length of left half
		// apply binary search:
		int low = 0, high = n1;
		while (low <= high) {
			int mid1 = (low + high) / 2;
			int mid2 = left - mid1;
			// calculate l1, l2, r1 and r2;
			int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
			int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
			int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
			int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

			if (l1 <= r2 && l2 <= r1) {
				if (n % 2 == 1)
					return Math.max(l1, l2);
				else
					return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
			} else if (l1 > r2)
				high = mid1 - 1;
			else
				low = mid1 + 1;
		}
		return 0; // dummy statement
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums1 = [1,3], nums2 = [2]
//		Output: 2.00000
//		Explanation: merged array = [1,2,3] and median is 2.
		System.out.println(
				new _4_Median_of_Two_Sorted_Arrays().findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));

//		Example 2:
//		Input: nums1 = [1,2], nums2 = [3,4]
//		Output: 2.50000
//		Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
		System.out.println(
				new _4_Median_of_Two_Sorted_Arrays().findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));

	}

}
