package neetcode250.e_binarysearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// https://www.youtube.com/watch?v=bkJeA7LnJww
public class _8_153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return nums[left];
	}
}
