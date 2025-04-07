package neetcode150.dynamic1d;

// https://leetcode.com/problems/house-robber/
// https://www.youtube.com/watch?v=VXqUQYGMnQg
public class _3_198_HouseRobber {

	public int rob(int[] nums) {
		// If only 1 element, just return it
		if (nums.length < 2)
			return nums[0];

		// Create array to store the maximum loot at each index
		int[] dp = new int[nums.length];

		// Memoize maximum loots at first 2 indexes
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		// Use them to fill complete array
		for (int i = 2; i < nums.length; i++) {

			// Core logic
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[nums.length - 1];
	}

    public int robOptimised(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
