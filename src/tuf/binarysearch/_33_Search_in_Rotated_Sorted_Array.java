package tuf.binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// https://www.youtube.com/watch?v=5qGrJbHhqFs
public class _33_Search_in_Rotated_Sorted_Array {

	public static int offset(int[] arr, int low, int high, int size) {
		int mid;
		while (low <= high) {
			mid = low + ((high - low) / 2);

			if (low == high || arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (arr[mid] > arr[size - 1]) {
				return offset(arr, mid + 1, high, size);
			} else {
				return offset(arr, low, mid - 1, size);
			}
		}

		return -1;
	}

	public static int bSearch(int[] arr, int low, int high, int val) {
		int mid;
		while (low <= high) {
			mid = low + ((high - low) / 2);
			if (arr[mid] == val) {
				return mid;
			} else if (arr[mid] < val) {
				return bSearch(arr, mid + 1, high, val);
			} else {
				return bSearch(arr, low, mid - 1, val);
			}
		}

		return -1;
	}

	public int search(int[] nums, int target) {
		int offset = offset(nums, 0, nums.length - 1, nums.length);
		if (offset == -1) {
			return bSearch(nums, 0, nums.length - 1, target);
		} else {
			int index = -1;

			index = bSearch(nums, 0, offset, target);
			if (index != -1) {
				return index;
			} else {
				index = bSearch(nums, offset + 1, nums.length - 1, target);
				return index;
			}
		}
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [4,5,6,7,0,1,2], target = 0
//		Output: 4
		System.out.println(new _33_Search_in_Rotated_Sorted_Array().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));

//		Example 2:
//		Input: nums = [4,5,6,7,0,1,2], target = 3
//		Output: -1
		System.out.println(new _33_Search_in_Rotated_Sorted_Array().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));

//		Example 3:
//		Input: nums = [1], target = 0
//		Output: -1
		System.out.println(new _33_Search_in_Rotated_Sorted_Array().search(new int[] { 1 }, 0));
	}

}
