package neetcode250.h_heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/ipo/
// https://www.youtube.com/watch?v=b12SZXrZF9I
public class _12_502_IPO {
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		int n = profits.length;

		List<int[]> projects = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			projects.add(new int[] { capital[i], profits[i] });
		}

		projects.sort(Comparator.comparingInt(a -> a[0]));

		PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());

		int i = 0;

		while (k-- > 0) {
			while (i < n && projects.get(i)[0] <= w) {
				maxProfitHeap.add(projects.get(i)[1]);
				i++;
			}
			if (maxProfitHeap.isEmpty()) {
				break;
			}
			w += maxProfitHeap.poll();
		}
		return w;
	}
}
