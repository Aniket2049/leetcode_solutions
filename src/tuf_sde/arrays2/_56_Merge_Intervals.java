package tuf_sde.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/description/
// https://www.youtube.com/watch?v=IexN60k62jo
public class _56_Merge_Intervals {

	public int[][] merge(int[][] intervals) {
		int n = intervals.length;

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ansAsList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (ansAsList.isEmpty() || intervals[i][0] > ansAsList.getLast().get(1)) {
				ArrayList<Integer> currentInterval = new ArrayList<Integer>();
				currentInterval.add(intervals[i][0]);
				currentInterval.add(intervals[i][1]);
				ansAsList.add(currentInterval);
			} else {
				List<Integer> lastList = ansAsList.getLast();
				int previousEndVal = lastList.get(1);
				lastList.set(1, Math.max(previousEndVal, intervals[i][1]));
			}
		}

		int[][] ansAsArray = new int[ansAsList.size()][2];
		for (int i = 0; i < ansAsList.size(); i++) {
			ansAsArray[i][0] = ansAsList.get(i).get(0);
			ansAsArray[i][1] = ansAsList.get(i).get(1);
		}

		utility.Print.printInt2DArray(ansAsArray);

		return ansAsArray;
	}

	public int[][] mergeBrute(int[][] intervals) {
		int n = intervals.length;

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ansAsList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];

			if (!ansAsList.isEmpty() && end <= ansAsList.get(ansAsList.size() - 1).get(1)) {
				continue;
			}

			for (int j = i + 1; j < n; j++) {
				if (intervals[j][0] <= end) {
					end = Math.max(end, intervals[j][1]);
				} else {
					break;
				}
			}

			ArrayList<Integer> currentInterval = new ArrayList<Integer>();
			currentInterval.add(start);
			currentInterval.add(end);
			ansAsList.add(currentInterval);
		}

		int[][] ansAsArray = new int[ansAsList.size()][2];
		for (int i = 0; i < ansAsList.size(); i++) {
			ansAsArray[i][0] = ansAsList.get(i).get(0);
			ansAsArray[i][1] = ansAsList.get(i).get(1);
		}

		utility.Print.printInt2DArray(ansAsArray);

		return ansAsArray;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//		Output: [[1,6],[8,10],[15,18]]
//		Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
		int[][] input = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//		new _56_Merge_Intervals().mergeBrute(input);
		new _56_Merge_Intervals().merge(input);

//		Example 2:
//		Input: intervals = [[1,4],[4,5]]
//		Output: [[1,5]]
//		Explanation: Intervals [1,4] and [4,5] are considered overlapping.
		input = new int[][] { { 1, 4 }, { 4, 5 } };
//		new _56_Merge_Intervals().mergeBrute(input);
		new _56_Merge_Intervals().merge(input);

	}

}
