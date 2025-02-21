package neetcode.twopointers;

// https://leetcode.com/problems/container-with-most-water/description/
// https://www.youtube.com/watch?v=UuiTKBwPgAo
public class _4_11_ContainerWithMostWater {

	public int maxArea(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int res = 0;

		while (l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			res = Math.max(res, area);
			if (height[l] <= height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		//49
		System.out.println(new _4_11_ContainerWithMostWater().maxArea(data));

	}

}
