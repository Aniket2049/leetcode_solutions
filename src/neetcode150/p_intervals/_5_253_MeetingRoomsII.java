package neetcode150.p_intervals;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/meeting-rooms-ii/
// https://www.lintcode.com/problem/919/
public class _5_253_MeetingRoomsII {
	public int minMeetingRooms(List<Interval> intervals) {
		int n = intervals.size();
		int[] start = new int[n];
		int[] end = new int[n];

		for (int i = 0; i < n; i++) {
			start[i] = intervals.get(i).start;
			end[i] = intervals.get(i).end;
		}

		Arrays.sort(start);
		Arrays.sort(end);

		int res = 0, count = 0, s = 0, e = 0;
		while (s < n) {
			if (start[s] < end[e]) {
				s++;
				count++;
			} else {
				e++;
				count--;
			}
			res = Math.max(res, count);
		}
		return res;
	}

	class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
