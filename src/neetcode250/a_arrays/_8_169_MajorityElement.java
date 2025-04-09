package neetcode250.a_arrays;

// https://leetcode.com/problems/majority-element/
// https://www.youtube.com/watch?v=wD7fs5P_MVo
public class _8_169_MajorityElement {
	public int majorityElement(int[] nums) {
		int majority = nums[0];
		int votes = 1;

		for (int i = 1; i < nums.length; i++) {
			if (votes == 0) {
				votes++;
				majority = nums[i];
			} else if (majority == nums[i]) {
				votes++;
			} else {
				votes--;
			}
		}

		return majority;
	}
}
