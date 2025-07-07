package neetcode250.o_greedy;

import java.util.Arrays;

// https://leetcode.com/problems/candy/
// https://www.youtube.com/watch?v=1IzCRCcK17A
public class _14_135_Candy {
	public int candy(int[] ratings) {
		int n = ratings.length;
		int[] arr = new int[n];
		Arrays.fill(arr, 1);

		for (int i = 1; i < n; i++) {
			if (ratings[i - 1] < ratings[i]) {
				arr[i] = arr[i - 1] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				arr[i] = Math.max(arr[i], arr[i + 1] + 1);
			}
		}

		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		return sum;
	}
}
