package neetcode250.e_binarysearch;

// https://leetcode.com/problems/binary-search/
// https://www.youtube.com/watch?v=s4DPM8ct1pI
public class _1_704_BinarySearch {
	public int search(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int mid = l + ((r - l) / 2);

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return -1;
	}
}
