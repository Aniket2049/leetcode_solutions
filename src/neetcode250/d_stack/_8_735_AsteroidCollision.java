package neetcode250.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/asteroid-collision/
// https://www.youtube.com/watch?v=7isfomHzzno
public class _8_735_AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stk = new Stack<Integer>();

		for (int a : asteroids) {
			while (!stk.isEmpty() && a < 0 && stk.peek() > 0) {
				int sum = a + stk.peek();
				if (sum < 0) {
					stk.pop();
				} else if (sum > 0) {
					a = 0;
					break;
				} else {
					stk.pop();
					a = 0;
				}
			}

			if (a != 0)
				stk.push(a);

		}

		int s = stk.size();

		int[] result = new int[s];
		int i = s - 1;
		while (!stk.isEmpty()) {
			result[i] = stk.peek();
			stk.pop();
			i--;
		}

		return result;
	}
}
