package neetcode150.e_binarysearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
// https://www.youtube.com/watch?v=F9c7LpRZWVQ
// https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
// https://www.youtube.com/watch?v=q6IEA26hvXc
public class _7_4_MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] A = nums1;
		int[] B = nums2;
		int total = A.length + B.length;
		int half = (total + 1) / 2;

		if (B.length < A.length) {
			int[] temp = A;
			A = B;
			B = temp;
		}

		int l = 0;
		int r = A.length;
		while (l <= r) {
			int i = (l + r) / 2;
			int j = half - i;

			int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
			int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
			int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
			int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

			if (Aleft <= Bright && Bleft <= Aright) {
				if (total % 2 != 0) {
					return Math.max(Aleft, Bleft);	//total elements are odd
				}
				return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;	//total elements are even
			} else if (Aleft > Bright) {
				r = i - 1;
			} else {
				l = i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 3 };
		int[] nums2 = new int[] { 2 };
		System.out.println(new _7_4_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));

		nums1 = new int[] { 1, 2 };
		nums2 = new int[] { 3, 4 };
		System.out.println(new _7_4_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));

	}

}
