package neetcode150.h_heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/task-scheduler/
// https://www.youtube.com/watch?v=s8p8ukTyA2I
public class _5_621_TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		for (char task : tasks) {
			count[task - 'A']++;
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int cnt : count) {
			if (cnt > 0) {
				maxHeap.add(cnt);
			}
		}

		int time = 0;
		Queue<int[]> q = new LinkedList<>();
		while (!maxHeap.isEmpty() || !q.isEmpty()) {
			time++;

			if (maxHeap.isEmpty()) {
				time = q.peek()[1];
			} else {
				int cnt = maxHeap.poll() - 1;
				if (cnt > 0) {
					q.add(new int[] { cnt, time + n });
				}
			}

			if (!q.isEmpty() && q.peek()[1] == time) {
				maxHeap.add(q.poll()[0]);
			}
		}

		return time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
