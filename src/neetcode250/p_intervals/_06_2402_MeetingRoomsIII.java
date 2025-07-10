package neetcode250.p_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-iii/
// https://www.youtube.com/watch?v=2VLwjvODQbA
public class _06_2402_MeetingRoomsIII {
	public int mostBooked(int n, int[][] meetings) {
		Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));
		PriorityQueue<Integer> available = new PriorityQueue<>();
		PriorityQueue<long[]> used = new PriorityQueue<>(
				(a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
		for (int i = 0; i < n; i++) {
			available.offer(i);
		}
		int[] count = new int[n];

		for (int[] meeting : meetings) {
			long start = meeting[0];
			long end = meeting[1];
			while (!used.isEmpty() && used.peek()[0] <= start) {
				int room = (int) used.poll()[1];
				available.offer(room);
			}
			if (available.isEmpty()) {
				long[] current = used.poll();
				int room = (int) current[1];
				end = current[0] + (end - start);
				available.offer(room);
			}

			int room = available.poll();
			used.offer(new long[] { end, room });
			count[room]++;
		}

		int maxRoom = 0;
		for (int i = 1; i < n; i++) {
			if (count[i] > count[maxRoom]) {
				maxRoom = i;
			}
		}
		return maxRoom;
	}
}
