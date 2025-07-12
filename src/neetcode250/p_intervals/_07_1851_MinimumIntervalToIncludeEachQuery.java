package neetcode250.p_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-interval-to-include-each-query/
// https://www.youtube.com/watch?v=5hQ5WWW5awQ
public class _07_1851_MinimumIntervalToIncludeEachQuery {
	public int[] minInterval(int[][] intervals, int[] queries) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		Map<Integer, Integer> res = new HashMap<>();
		int i = 0;
		for (int q : Arrays.stream(queries).sorted().toArray()) {
			while (i < intervals.length && intervals[i][0] <= q) {
				int l = intervals[i][0];
				int r = intervals[i][1];
				minHeap.offer(new int[] { r - l + 1, r });
				i++;
			}

			while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
				minHeap.poll();
			}
			res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
		}
		int[] result = new int[queries.length];
		for (int j = 0; j < queries.length; j++) {
			result[j] = res.get(queries[j]);
		}
		return result;
	}
}
