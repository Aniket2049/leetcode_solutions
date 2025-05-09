package tuf_sde.greedy;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
// https://takeuforward.org/data-structure/minimum-number-of-platforms-required-for-a-railway/
public class Minimum_number_of_platforms_required_for_a_railway {

	static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {

			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;
			}

			else if (arr[i] > dep[j]) {
				plat_needed--;
				j++;
			}

			if (plat_needed > result)
				result = plat_needed;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
		int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
		int n = arr.length;
		int totalCount = findPlatform(arr, dep, n);
		System.out.println("Minimum number of Platforms required " + totalCount);

	}

}
