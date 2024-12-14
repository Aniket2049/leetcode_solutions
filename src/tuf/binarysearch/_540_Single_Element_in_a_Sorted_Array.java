package tuf.binarysearch;

// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
// https://www.youtube.com/watch?v=AZOmHuHadxQ
public class _540_Single_Element_in_a_Sorted_Array {

	public int singleNonDuplicate(int[] nums) {
		int n = nums.length; // Size of the array.

		// Edge cases:
		if (n == 1)
			return nums[0];
		if (nums[0] != nums[1])
			return nums[0];
		if (nums[n - 1] != nums[n - 2])
			return nums[n - 1];

		int low = 1, high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2;

			// If nums[mid] is the single element:
			if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
				return nums[mid];
			}

			// We are in the left:
			if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
				// Eliminate the left half:
				low = mid + 1;
			}
			// We are in the right:
			else {
				// Eliminate the right half:
				high = mid - 1;
			}
		}

		// Dummy return statement:
		return -1;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,1,2,3,3,4,4,8,8]
//		Output: 2
		System.out.println(new _540_Single_Element_in_a_Sorted_Array()
				.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));

//		Example 2:
//		Input: nums = [3,3,7,7,10,11,11]
//		Output: 10
		System.out.println(
				new _540_Single_Element_in_a_Sorted_Array().singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
	}

}
