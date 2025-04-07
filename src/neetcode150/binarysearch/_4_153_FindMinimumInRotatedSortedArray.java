package neetcode150.binarysearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// https://www.youtube.com/watch?v=H2U24n4bcQQ
// https://neetcode.io/solutions/find-minimum-in-rotated-sorted-array
public class _4_153_FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 5, 1, 2 };
		System.out.println(new _4_153_FindMinimumInRotatedSortedArray().findMin(arr));

		arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(new _4_153_FindMinimumInRotatedSortedArray().findMin(arr));

		arr = new int[] { 11, 13, 15, 17 };
		System.out.println(new _4_153_FindMinimumInRotatedSortedArray().findMin(arr));

	}

}
