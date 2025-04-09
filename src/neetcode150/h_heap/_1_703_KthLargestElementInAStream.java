package neetcode150.h_heap;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
// https://www.youtube.com/watch?v=hOjcdrqMoQ8
// https://www.youtube.com/watch?v=0tFmP1Eiilg
public class _1_703_KthLargestElementInAStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class KthLargest {
	private int k;
	private Queue<Integer> nums;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		this.nums = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			this.nums.add(nums[i]);
			if (this.nums.size() > k) {
				this.nums.poll();
			}
		}
	}

	public int add(int val) {
		nums.add(val);
		if (nums.size() > k) {
			nums.poll();
		}
		return nums.peek();
	}
}