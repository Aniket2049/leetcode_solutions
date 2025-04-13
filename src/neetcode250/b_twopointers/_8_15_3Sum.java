package neetcode250.b_twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/3sum/
// https://www.youtube.com/watch?v=cRBSOz49fQk
public class _8_15_3Sum {
	public List<List<Integer>> threeSum(int[] arr) {
		if (arr == null || arr.length < 3)
			return new ArrayList<>();

		// Sort the elements
		Arrays.sort(arr);
		Set<List<Integer>> result = new HashSet<>();

		// Now fix the first element and find the other two elements
		for (int i = 0; i < arr.length - 2; i++) {
			// Find other two elements using Two Sum approach
			int left = i + 1;
			int right = arr.length - 1;

			while (left < right) {
				int sum = arr[i] + arr[left] + arr[right];

				if (sum == 0) {

					// Add the set, and move to find other triplets
					result.add(Arrays.asList(arr[i], arr[left], arr[right]));
					left++;
					right--;
				} else if (sum < 0)
					left++;
				else
					right--;
			}
		}
		return new ArrayList<>(result);
	}
}
