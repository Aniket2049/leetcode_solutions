package tuf.arrays4;

import java.util.HashMap;
import java.util.Map;

// https://www.interviewbit.com/problems/subarray-with-given-xor/
// https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
public class Subarray_with_given_XOR {

	public int subarraysWithXorK(int[] a, int k) {
		int n = a.length; // size of the given array.
		int xr = 0;
		Map<Integer, Integer> mpp = new HashMap<>(); // declaring the map.
		mpp.put(xr, 1); // setting the value of 0.
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			// prefix XOR till index i:
			xr = xr ^ a[i];

			// By formula: x = xr^k:
			int x = xr ^ k;

			// add the occurrence of xr^k
			// to the count:
			if (mpp.containsKey(x)) {
				cnt += mpp.get(x);
			}

			// Insert the prefix xor till index i
			// into the map:
			if (mpp.containsKey(xr)) {
				mpp.put(xr, mpp.get(xr) + 1);
			} else {
				mpp.put(xr, 1);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
//		Input 1:
//		 A = [4, 2, 2, 6, 4]
//		 B = 6
//		Example Output
//		Output 1:
//		 4

		System.out.println(new Subarray_with_given_XOR().subarraysWithXorK(new int[] { 4, 2, 2, 6, 4 }, 6));

//		Input 2:
//		 A = [5, 6, 7, 8, 9]
//		 B = 5
//		Output 2:
//		 2
		System.out.println(new Subarray_with_given_XOR().subarraysWithXorK(new int[] { 5, 6, 7, 8, 9 }, 5));

	}

}
