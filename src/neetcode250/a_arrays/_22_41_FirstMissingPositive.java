package neetcode250.a_arrays;

// https://leetcode.com/problems/first-missing-positive/
// https://www.youtube.com/watch?v=8g78yfzMlao
public class _22_41_FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {
				nums[i] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			int val = Math.abs(nums[i]);
			if (val >= 1 && val <= n) {
				if (nums[val - 1] > 0) {
					nums[val - 1] *= -1;
				} else if (nums[val - 1] == 0) {
					nums[val - 1] = -1 * (n + 1);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (nums[i - 1] >= 0) {
				return i;
			}
		}

		return n + 1;
	}
}
