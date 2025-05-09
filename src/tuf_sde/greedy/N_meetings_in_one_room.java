package tuf_sde.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
// https://takeuforward.org/data-structure/n-meetings-in-one-room/
public class N_meetings_in_one_room {

	static void maxMeetings(int start[], int end[], int n) {
		ArrayList<meeting> meet = new ArrayList<>();

		for (int i = 0; i < start.length; i++)
			meet.add(new meeting(start[i], end[i], i + 1));

		meetingComparator mc = new meetingComparator();
		Collections.sort(meet, mc);
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(meet.get(0).pos);
		int limit = meet.get(0).end;

		for (int i = 1; i < start.length; i++) {
			if (meet.get(i).start > limit) {
				limit = meet.get(i).end;
				answer.add(meet.get(i).pos);
			}
		}
		System.out.println("The order in which the meetings will be performed is ");
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 5, 7, 9, 9 };
		maxMeetings(start, end, n);

//		Examples :
//		Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
//		Output: 4
//		Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)

//		Input: start[] = [10, 12, 20], end[] = [20, 25, 30]
//		Output: 1
//		Explanation: Only one meetings can be held with given start and end timings.

//		Input: start[] = [1, 2], end[] = [100, 99]
//		Output: 1
	}

}

class meetingComparator implements Comparator<meeting> {
	@Override
	public int compare(meeting o1, meeting o2) {
		if (o1.end < o2.end)
			return -1;
		else if (o1.end > o2.end)
			return 1;
		else if (o1.pos < o2.pos)
			return -1;
		return 1;
	}
}

class meeting {
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}