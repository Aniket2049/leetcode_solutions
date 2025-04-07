package neetcode150.twopointers;

// https://leetcode.com/problems/trapping-rain-water/
// https://www.youtube.com/watch?v=ZI2z5pq0TqA
public class _5_42_TrappingRainWater {

	public int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int l = 0, r = height.length - 1;
		int leftMax = height[l], rightMax = height[r];
		int res = 0;
		while (l < r) {
			if (leftMax < rightMax) {
				l++;
				leftMax = Math.max(leftMax, height[l]);
				res += leftMax - height[l];
			} else {
				r--;
				rightMax = Math.max(rightMax, height[r]);
				res += rightMax - height[r];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		//6
		System.out.println(new _5_42_TrappingRainWater().trap(data));

	}

}
