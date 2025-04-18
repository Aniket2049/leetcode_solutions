package neetcode250.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/baseball-game/
// https://www.youtube.com/watch?v=Id_tqGdsZQI
public class _1_682_BaseballGame {
	public int calPoints(String[] operations) {
		Stack<Integer> stk = new Stack<Integer>();

		for (int i = 0; i < operations.length; i++) {
			String currentOp = operations[i];
			if (currentOp.equals("+")) {
				int n1 = stk.pop();
				int n2 = stk.pop();
				stk.push(n2);
				stk.push(n1);
				stk.push(n1 + n2);
			} else if (currentOp.equals("D")) {
				int n = stk.peek();
				stk.push(n * 2);
			} else if (currentOp.equals("C")) {
				stk.pop();
			} else {
				stk.push(Integer.parseInt(currentOp));
			}
		}

		int res = 0;
		while (!stk.isEmpty()) {
			res += stk.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		String[] data = new String[] { "5", "2", "C", "D", "+" };
		System.out.println(new _1_682_BaseballGame().calPoints(data));
	}
}
