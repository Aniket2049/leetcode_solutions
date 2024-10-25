package tuf.arrays;

// https://leetcode.com/problems/sort-colors/description/
// https://www.youtube.com/watch?v=tp8JIuCXBaU
// https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
public class _75_SortColors {
	public void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1; // 3 pointers

		while (mid <= high) {
			if (nums[mid] == 0) {
				// swapping nums[low] and nums[mid]
				int temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;

				low++;
				mid++;

			} else if (nums[mid] == 1) {
				mid++;

			} else {
				// swapping nums[mid] and nums[high]
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;

				high--;
			}
		}

//		System.out.print("[");
//		for (int i = 0; i < nums.length; i++) {
//			if (i == nums.length - 1)
//				System.out.print(nums[i]);
//			else
//				System.out.print(nums[i] + ",");
//		}
//		System.out.print("]");
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [2,0,2,1,1,0]
//		Output: [0,0,1,1,2,2]
		new _75_SortColors().sortColors(new int[] {2,0,2,1,1,0});
//		Example 2:
//		Input: nums = [2,0,1]
//		Output: [0,1,2]
		new _75_SortColors().sortColors(new int[] {2,0,1});

	}

}
