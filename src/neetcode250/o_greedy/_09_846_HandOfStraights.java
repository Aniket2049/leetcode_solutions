package neetcode250.o_greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/hand-of-straights/
// https://www.youtube.com/watch?v=amnrMCVd2YI
public class _09_846_HandOfStraights {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0)
			return false;

		Map<Integer, Integer> count = new HashMap<>();
		for (int n : hand)
			count.put(n, 1 + count.getOrDefault(n, 0));

		PriorityQueue<Integer> minH = new PriorityQueue<>(count.keySet());
		while (!minH.isEmpty()) {
			int first = minH.peek();
			for (int i = first; i < first + groupSize; i++) {
				if (!count.containsKey(i))
					return false;
				count.put(i, count.get(i) - 1);
				if (count.get(i) == 0) {
					if (i != minH.peek())
						return false;
					minH.poll();
				}
			}
		}
		return true;
	}
}
