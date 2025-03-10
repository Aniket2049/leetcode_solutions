package neetcode.binarysearch;

// https://leetcode.com/problems/binary-search/description/
// https://www.youtube.com/watch?v=s4DPM8ct1pI
public class _1_704_BinarySearch {

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
//			int mid = left + ((right - left) / 2);	// integer overflow condition 

			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
		int target = 9;

		System.out.println(new _1_704_BinarySearch().search(nums, target));

		nums = new int[] { -1, 0, 3, 5, 9, 12 };
		target = 2;

		System.out.println(new _1_704_BinarySearch().search(nums, target));

	}

}
