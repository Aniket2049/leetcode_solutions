package neetcode250.b_twopointers;

// https://leetcode.com/problems/container-with-most-water/
// https://www.youtube.com/watch?v=w7ftYsZtIbs
public class _11_11_ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			maxArea = Math.max(area, maxArea);

			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}
}
