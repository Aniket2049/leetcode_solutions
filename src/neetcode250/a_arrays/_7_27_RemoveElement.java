package neetcode250.a_arrays;

// https://leetcode.com/problems/remove-element/
// https://www.youtube.com/watch?v=opmnMBAEe8E
public class _7_27_RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i = 0, n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[--n];
			} else {
				i++;
			}
		}
		return n;
	}
}
