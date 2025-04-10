package neetcode250.a_arrays;

// https://leetcode.com/problems/sort-colors/
// https://www.youtube.com/watch?v=6sMssUHgaBs
public class _12_75_SortColors {
	private void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	public void sortColors(int[] nums) {
		int start = 0;
		int mid = 0;
		int end = nums.length - 1;

		while (mid <= end) {

			switch (nums[mid]) {
			case 0:
				// Swap with start index
				swap(nums, start, mid);
				mid++;
				start++;
				break;

			case 1:
				mid++;
				break;

			case 2:
				// Swap with end index
				swap(nums, mid, end);
				end--;
				break;
			}
		}
	}
}
