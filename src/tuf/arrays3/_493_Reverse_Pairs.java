package tuf.arrays3;

import java.util.ArrayList;

// https://leetcode.com/problems/reverse-pairs/description/
// https://www.youtube.com/watch?v=0e4bZaP3MDI
public class _493_Reverse_Pairs {
	private static void merge(int[] arr, int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>(); // temporary array
		int left = low; // starting index of left half of arr
		int right = mid + 1; // starting index of right half of arr

		// storing elements in the temporary array in a sorted manner//

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		// if elements on the left half are still left //

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		// if elements on the right half are still left //
		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		// transfering all elements from temporary to arr //
		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
	}

	public static int countPairs(int[] arr, int low, int mid, int high) {
		int right = mid + 1;
		int cnt = 0;
		for (int i = low; i <= mid; i++) {
			while (right <= high && arr[i] > 2L * arr[right])
				right++;
			cnt += (right - (mid + 1));
		}
		return cnt;
	}

	public static int mergeSort(int[] arr, int low, int high) {
		int cnt = 0;
		if (low >= high)
			return 0;
		int mid = (low + high) / 2;
		cnt += mergeSort(arr, low, mid); // left half
		cnt += mergeSort(arr, mid + 1, high); // right half
		cnt += countPairs(arr, low, mid, high); // Modification
		merge(arr, low, mid, high); // merging sorted halves
		return cnt;
	}

	public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,3,2,3,1]
//		Output: 2
//		Explanation: The reverse pairs are:
//		(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
//		(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
		System.out.println(new _493_Reverse_Pairs().reversePairs(new int[] { 1, 3, 2, 3, 1 }));

//		Example 2:
//		Input: nums = [2,4,3,5,1]
//		Output: 3
//		Explanation: The reverse pairs are:
//		(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
//		(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
//		(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
		System.out.println(new _493_Reverse_Pairs().reversePairs(new int[] { 2, 4, 3, 5, 1 }));
		
		System.out.println(new _493_Reverse_Pairs().reversePairs(new int[] { 2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
	}

}
