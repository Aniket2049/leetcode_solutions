package tuf_sde.stack_queue2;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/description/
// https://www.youtube.com/watch?v=DfljaUwZsOk
// https://neetcode.io/solutions/sliding-window-maximum
public class _239_Sliding_Window_Maximum {

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
//		Example 1:
//		Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//		Output: [3,3,5,5,6,7]
//		Explanation: 
//		Window position                Max
//		---------------               -----
//		[1  3  -1] -3  5  3  6  7       3
//		 1 [3  -1  -3] 5  3  6  7       3
//		 1  3 [-1  -3  5] 3  6  7       5
//		 1  3  -1 [-3  5  3] 6  7       5
//		 1  3  -1  -3 [5  3  6] 7       6
//		 1  3  -1  -3  5 [3  6  7]      7
		
//		Example 2:
//		Input: nums = [1], k = 1
//		Output: [1]

	}

}
