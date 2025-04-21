package neetcode250.e_binarysearch;

// https://leetcode.com/problems/search-insert-position/
// https://www.youtube.com/watch?v=p07ahfFzMi0
public class _2_35_SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}
}
