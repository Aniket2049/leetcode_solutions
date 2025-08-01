package neetcode250.o_greedy;

// https://leetcode.com/problems/jump-game-ii/
// https://www.youtube.com/watch?v=9kyHYVxL4fw
public class _06_45_JumpGameII {
	public int jump(int[] nums) {
		int res = 0, l = 0, r = 0;

		while (r < nums.length - 1) {
			int farthest = 0;
			for (int i = l; i <= r; i++) {
				farthest = Math.max(farthest, i + nums[i]);
			}
			l = r + 1;
			r = farthest;
			res++;
		}
		return res;
	}
}
