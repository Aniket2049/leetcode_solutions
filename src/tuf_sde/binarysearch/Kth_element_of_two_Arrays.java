package tuf_sde.binarysearch;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
// https://www.youtube.com/watch?v=nv7F4PiLUzo
// https://takeuforward.org/data-structure/k-th-element-of-two-sorted-arrays/
public class Kth_element_of_two_Arrays {

	public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
		if (m > n)
			return kthElement(b, a, n, m, k);

		int left = k; // length of left half

		// apply binary search:
		int low = Math.max(0, k - n), high = Math.min(k, m);
		while (low <= high) {
			int mid1 = (low + high) >> 1;
			int mid2 = left - mid1;
			// calculate l1, l2, r1, and r2
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			if (mid1 < m)
				r1 = a.get(mid1);
			if (mid2 < n)
				r2 = b.get(mid2);
			if (mid1 - 1 >= 0)
				l1 = a.get(mid1 - 1);
			if (mid2 - 1 >= 0)
				l2 = b.get(mid2 - 1);

			if (l1 <= r2 && l2 <= r1) {
				return Math.max(l1, l2);
			}

			// eliminate the halves:
			else if (l1 > r2)
				high = mid1 - 1;
			else
				low = mid1 + 1;
		}
		return 0; // dummy statement
	}

	public static void main(String[] args) {
//		Examples :
//		Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
//		Output: 6
//		Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.

//		Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
//		Output: 256
//		Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.

		ArrayList<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(3);
		a.add(6);
		a.add(7);
		a.add(9);

		ArrayList<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(4);
		b.add(8);
		b.add(10);

		System.out.println("The k-th element of two sorted arrays is: " + kthElement(a, b, a.size(), b.size(), 5));

	}

}
