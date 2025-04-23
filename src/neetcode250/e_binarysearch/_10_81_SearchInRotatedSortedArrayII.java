package neetcode250.e_binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// https://www.youtube.com/watch?v=oUnF7o88_Xc
public class _10_81_SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (nums[m] == target) {
				return true;
			}

			if (nums[l] < nums[m]) { // Left portion
				if (nums[l] <= target && target < nums[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else if (nums[l] > nums[m]) { // Right portion
				if (nums[m] < target && target <= nums[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			} else {
				l++;
			}
		}

		return false;
	}
}
