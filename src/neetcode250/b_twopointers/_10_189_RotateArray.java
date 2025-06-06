package neetcode250.b_twopointers;

// https://leetcode.com/problems/rotate-array/
// https://www.youtube.com/watch?v=BHr381Guz3Y
public class _10_189_RotateArray {
	private void reverse(int[] nums, int l, int r) {
		while (l < r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;

		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}
}
