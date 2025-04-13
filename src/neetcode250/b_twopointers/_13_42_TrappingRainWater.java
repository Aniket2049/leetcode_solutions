package neetcode250.b_twopointers;

// https://leetcode.com/problems/trapping-rain-water/
// https://www.youtube.com/watch?v=KFdHpOlz8hs
public class _13_42_TrappingRainWater {
	public int trap(int[] height) {
		int n = height.length;
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];

		int lWall = 0, rWall = 0;

		for (int i = 0; i < n; i++) {
			int j = n - i - 1;
			maxLeft[i] = lWall;
			maxRight[j] = rWall;
			lWall = Math.max(lWall, height[i]);
			rWall = Math.max(rWall, height[j]);
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int pot = Math.min(maxLeft[i], maxRight[i]);
			sum += Math.max(0, pot - height[i]);
		}

		return sum;
	}
}
