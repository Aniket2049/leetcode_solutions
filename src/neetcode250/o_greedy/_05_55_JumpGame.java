package neetcode250.o_greedy;

// https://leetcode.com/problems/jump-game/
// https://www.youtube.com/watch?v=Gtugy3mRV-A 
public class _05_55_JumpGame {
	public boolean canJump(int[] nums) {
		// Initially the final position is the last index
		int finalPosition = nums.length - 1;

		// Start with the second last index
		for (int idx = nums.length - 2; idx >= 0; idx--) {

			// If you can reach the final position from this index
			// update the final position flag
			if (idx + nums[idx] >= finalPosition) {
				finalPosition = idx;
			}
		}

		// If we reach the first index, then we can
		// make the jump possible
		return finalPosition == 0;
	}
}
