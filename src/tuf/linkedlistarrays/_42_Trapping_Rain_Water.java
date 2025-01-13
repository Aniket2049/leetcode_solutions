package tuf.linkedlistarrays;

// https://leetcode.com/problems/trapping-rain-water/description/
// https://www.youtube.com/watch?v=1_5VuquLbXg
// https://www.youtube.com/watch?v=LBmzlYs5ygs
public class _42_Trapping_Rain_Water {

	public int trap(int[] height) {
		int n = height.length;
		int left = 0, right = n - 1;
		int res = 0;
		int maxLeft = 0, maxRight = 0;
		while (left <= right) {
			if (height[left] <= height[right]) {
				if (height[left] >= maxLeft) {
					maxLeft = height[left];
				} else {
					res += maxLeft - height[left];
				}
				left++;
			} else {
				if (height[right] >= maxRight) {
					maxRight = height[right];
				} else {
					res += maxRight - height[right];
				}
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//		Output: 6
//		Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

		System.out.println(new _42_Trapping_Rain_Water().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));

//		Example 2:
//		Input: height = [4,2,0,3,2,5]
//		Output: 9

		System.out.println(new _42_Trapping_Rain_Water().trap(new int[] { 4, 2, 0, 3, 2, 5 }));

	}

}
