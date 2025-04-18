package neetcode250.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// https://www.youtube.com/watch?v=iu0082c4HDE
public class _6_150_EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stk = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			String currentToken = tokens[i];
			if (currentToken.equals("+")) {
				int n1 = stk.pop();
				int n2 = stk.pop();
				stk.push(n1 + n2);
			} else if (currentToken.equals("-")) {
				int n1 = stk.pop();
				int n2 = stk.pop();
				stk.push(n2 - n1);
			} else if (currentToken.equals("*")) {
				int n1 = stk.pop();
				int n2 = stk.pop();
				stk.push(n1 * n2);
			} else if (currentToken.equals("/")) {
				int n1 = stk.pop();
				int n2 = stk.pop();
				stk.push(n2 / n1);
			} else {
				stk.push(Integer.parseInt(currentToken));
			}
		}

		return stk.peek();
	}

	public static void main(String[] args) {
		String[] data = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(new _6_150_EvaluateReversePolishNotation().evalRPN(data));
	}
}
