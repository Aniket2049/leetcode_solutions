package neetcode150.p_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-interval-to-include-each-query/
// https://algo.monster/liteproblems/1851
// https://www.youtube.com/watch?v=5hQ5WWW5awQ
public class _6_1851_MinimumIntervalToIncludeEachQuery {
	public int[] minInterval(int[][] intervals, int[] queries) {
		int numIntervals = intervals.length, numQueries = queries.length;

		// Sort the intervals based on their starting points
		Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

		// Pair each query with its original index and sort by query value
		int[][] queriesWithIndices = new int[numQueries][];
		for (int i = 0; i < numQueries; ++i) {
			queriesWithIndices[i] = new int[] { queries[i], i };
		}
		Arrays.sort(queriesWithIndices, (query1, query2) -> query1[0] - query2[0]);

		// Initialize the answer array with -1 (indicating no interval found)
		int[] answer = new int[numQueries];
		Arrays.fill(answer, -1);

		// Use a priority queue to store intervals with smallest size (end - start + 1) on top
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((interval1, interval2) -> interval1[0] - interval2[0]);
		int index = 0;

		// Process each query
		for (int[] queryWithIndex : queriesWithIndices) {
			int queryValue = queryWithIndex[0];

			// Add intervals to the priority queue where the start is less than or equal to the query value
			while (index < numIntervals && intervals[index][0] <= queryValue) {
				int start = intervals[index][0], end = intervals[index][1];
				minHeap.offer(new int[] { end - start + 1, end });
				++index;
			}

			// Remove intervals from the queue which end before the query value
			while (!minHeap.isEmpty() && minHeap.peek()[1] < queryValue) {
				minHeap.poll();
			}

			// If the queue is not empty, there is an interval covering the query value
			if (!minHeap.isEmpty()) {
				// The size of the smallest interval covering the query is stored in the answer array
				answer[queryWithIndex[1]] = minHeap.peek()[0];
			}
		}

		return answer; // Return the array containing the size of smallest interval covering each query
	}
}
