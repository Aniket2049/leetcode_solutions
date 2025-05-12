package neetcode250.h_heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// https://www.youtube.com/watch?v=hOjcdrqMoQ8
public class _1_703_KthLargestElementInAStream {
	class KthLargest {

		private int limit;
		private PriorityQueue<Integer> minHeap;

		public KthLargest(int k, int[] nums) {
			this.limit = k;
			minHeap = new PriorityQueue<Integer>();
			for (int n : nums) {
				add(n);
			}
		}

		public int add(int val) {
			minHeap.add(val);
			if (minHeap.size() > limit)
				minHeap.poll();
			return minHeap.peek();
		}
	}
}
