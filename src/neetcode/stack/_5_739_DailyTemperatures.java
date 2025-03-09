package neetcode.stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/description/
// https://www.youtube.com/watch?v=_ZEvmycwXHs
public class _5_739_DailyTemperatures {

	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] answer = new int[n];
		Stack<Integer[]> stack = new Stack<Integer[]>();

		for (int i = 0; i < n; i++) {
			int currentTemp = temperatures[i];
			while (!stack.isEmpty() && stack.peek()[0] < currentTemp) {
				Integer[] stackTopData = stack.pop();
				int stackTD_t = stackTopData[0];
				int stackTD_i = stackTopData[1];
				answer[stackTD_i] = i - stackTD_i;
			}

			stack.push(new Integer[] { currentTemp, i });
		}

		return answer;
	}

	public static void main(String[] args) {
		// [1,1,4,2,1,1,0,0]
		System.out.println(Arrays.toString(
				new _5_739_DailyTemperatures().dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));

		// [1,1,1,0]
		System.out.println(
				Arrays.toString(new _5_739_DailyTemperatures().dailyTemperatures(new int[] { 30, 40, 50, 60 })));

		// [1,1,0]
		System.out.println(Arrays.toString(new _5_739_DailyTemperatures().dailyTemperatures(new int[] { 30, 60, 90 })));

	}

}
