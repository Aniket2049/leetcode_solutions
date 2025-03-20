package neetcode.graph2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/network-delay-time/
// https://www.youtube.com/watch?v=EaphyqKU4PQ
public class _1_743_NetworkDelayTime {

	//dijkstra
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> edges = new HashMap<>();
		for (int[] time : times) {
			edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] { time[1], time[2] });
		}

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		minHeap.offer(new int[] { 0, k });

		Set<Integer> visited = new HashSet<>();
		int t = 0;
		while (!minHeap.isEmpty()) {
			int[] curr = minHeap.poll();
			int w1 = curr[0], n1 = curr[1];
			if (visited.contains(n1)) {
				continue;
			}
			visited.add(n1);
			t = w1;

			if (edges.containsKey(n1)) {
				for (int[] next : edges.get(n1)) {
					int n2 = next[0], w2 = next[1];
					if (!visited.contains(n2)) {
						minHeap.offer(new int[] { w1 + w2, n2 });
					}
				}
			}
		}

		return visited.size() == n ? t : -1;
	}

	public static void main(String[] args) {
		int[][] times = new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int n = 4, k = 2;
		
		System.out.println(new _1_743_NetworkDelayTime().networkDelayTime(times, n, k));

	}

}
