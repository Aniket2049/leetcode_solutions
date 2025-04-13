package neetcode250.b_twopointers;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// https://www.youtube.com/watch?v=DEJAZBq0FDA
public class _6_26_RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int l = 1;

		for (int r = 1; r < nums.length; r++) {
			if (nums[r] != nums[r - 1]) {
				nums[l] = nums[r];
				l++;
			}
		}

		return l;
	}
}
