package neetcode150.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/
// https://www.youtube.com/watch?v=B-QCq79-Vfw
public class _2_1046_LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
		if (stones.length == 1)
			return stones[0];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int i = 0; i < stones.length; i++) {
			maxHeap.add(stones[i]);
		}
		int res = 0;
		while (!maxHeap.isEmpty()) {
			int n1 = maxHeap.poll();
			int n2 = maxHeap.poll();
			int result = Math.abs(n2 - n1);
			res = result;
			if (maxHeap.isEmpty()) {
				break;
			}
			maxHeap.add(result);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 7, 4, 1, 8, 1 };
		System.out.println(new _2_1046_LastStoneWeight().lastStoneWeight(arr));

	}

}
