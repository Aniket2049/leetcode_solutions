package neetcode.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
// https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/6186858/video-4-solutions-with-sorting-heap-counting-sort-and-quick-select/
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
