package neetcode250.p_intervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/meeting-rooms/
// https://www.youtube.com/watch?v=PaJxqZVPhbg
public class _04_252_MeetingRooms {
	public class Interval {
		public int start, end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public boolean canAttendMeetings(List<Interval> intervals) {
		Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

		for (int i = 1; i < intervals.size(); i++) {
			Interval i1 = intervals.get(i - 1);
			Interval i2 = intervals.get(i);

			if (i1.end > i2.start) {
				return false;
			}
		}

		return true;
	}
}
