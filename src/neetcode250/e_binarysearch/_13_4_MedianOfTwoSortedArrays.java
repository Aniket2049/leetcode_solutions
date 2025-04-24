package neetcode250.e_binarysearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
// https://www.youtube.com/watch?v=q6IEA26hvXc
public class _13_4_MedianOfTwoSortedArrays {
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
					return Math.max(Aleft, Bleft);
				}
				return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
			} else if (Aleft > Bright) {
				r = i - 1;
			} else {
				l = i + 1;
			}
		}
		return -1;
	}
}
