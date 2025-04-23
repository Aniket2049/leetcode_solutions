package neetcode250.e_binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// https://www.youtube.com/watch?v=iXLMMbdjeNM
public class _9_33_SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		int n = nums.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			// if mid points to the target
			if (nums[mid] == target)
				return mid;

			// if left part is sorted
			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target <= nums[mid]) {
					// element exists
					high = mid - 1;
				} else {
					// element does not exist
					low = mid + 1;
				}
			} else { // if right part is sorted
				if (nums[mid] <= target && target <= nums[high]) {
					// element exists
					low = mid + 1;
				} else {
					// element does not exist
					high = mid - 1;
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] data = new int[] { 5, 1, 3 };
		System.out.println(new _9_33_SearchInRotatedSortedArray().search(data, 5));
	}
}
