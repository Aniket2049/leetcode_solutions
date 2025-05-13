package neetcode250.h_heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
// https://www.youtube.com/watch?v=ZmGk7h8KZLs
public class _4_215_KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : nums) {
			minHeap.offer(num);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}
}
