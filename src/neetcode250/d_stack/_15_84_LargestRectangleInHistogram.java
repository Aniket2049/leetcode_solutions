package neetcode250.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
// https://www.youtube.com/watch?v=zx5Sw9130L0
// https://www.youtube.com/watch?v=ZGMw8Bvpwd4
public class _15_84_LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<int[]> stack = new Stack<>(); // pair: (index, height)

		for (int i = 0; i < heights.length; i++) {
			int start = i;
			while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
				int[] top = stack.pop();
				int index = top[0];
				int height = top[1];
				maxArea = Math.max(maxArea, height * (i - index));
				start = index;
			}
			stack.push(new int[] { start, heights[i] });
		}

		for (int[] pair : stack) {
			int index = pair[0];
			int height = pair[1];
			maxArea = Math.max(maxArea, height * (heights.length - index));
		}
		return maxArea;
	}
}
