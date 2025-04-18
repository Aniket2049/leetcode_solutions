package neetcode250.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
// https://www.youtube.com/watch?v=ekFs9Nb2RNQ
public class _9_739_DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stk = new Stack<Integer>();
		int n = temperatures.length;
		int[] result = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (!stk.isEmpty() && temperatures[i] >= temperatures[stk.peek()]) {
				stk.pop();
			}

			if (!stk.isEmpty()) {
				result[i] = stk.peek() - i;
			}

			stk.push(i);
		}

		return result;
	}
}
