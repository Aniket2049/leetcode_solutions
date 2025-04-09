package neetcode150.c_slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/description/
// https://www.youtube.com/watch?v=DfljaUwZsOk
// https://algo.monster/liteproblems/239
public class _6_239_SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] output = new int[n - k + 1];
		Deque<Integer> q = new LinkedList<>();
		int l = 0, r = 0;

		while (r < n) {
			while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
				q.removeLast();
			}
			q.addLast(r);

			if (l > q.getFirst()) {
				q.removeFirst();
			}

			if ((r + 1) >= k) {
				output[l] = nums[q.getFirst()];
				l++;
			}
			r++;
		}

		return output;
	}

	public static void main(String[] args) {
//		Input: nums = [1,2,1,0,4,2,6], k = 3
//		Output: [2,2,4,4,6]
//		Explanation: 
//		Window position            Max
//		---------------           -----
//		[1  2  1] 0  4  2  6        2
//		 1 [2  1  0] 4  2  6        2
//		 1  2 [1  0  4] 2  6        4
//		 1  2  1 [0  4  2] 6        4
//		 1  2  1  0 [4  2  6]       6

	}

}
