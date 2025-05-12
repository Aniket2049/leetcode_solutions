package neetcode250.h_heap;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/
// https://www.youtube.com/watch?app=desktop&v=8txOQt0ZwTg
public class _2_1046_LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		// Create a priority queue
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		// Add all stones to the priority queue
		for (int stone : stones)
			pq.add(stone);

		// While there are more than 1 stone
		while (pq.size() > 1) {

			// Get the two heaviest stones
			int y = pq.poll();
			int x = pq.poll();

			// If the stones are not equal
			if (x != y) {
				pq.add(y - x);
			}
		}

		return pq.isEmpty() ? 0 : pq.poll();
	}

}
