package neetcode150.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
// https://www.youtube.com/watch?v=iu0082c4HDE
public class _3_150_EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String c : tokens) {
			if (c.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (c.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if (c.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (c.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				stack.push(Integer.parseInt(c));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(new _3_150_EvaluateReversePolishNotation().evalRPN(tokens));

		tokens = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(new _3_150_EvaluateReversePolishNotation().evalRPN(tokens));

		tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(new _3_150_EvaluateReversePolishNotation().evalRPN(tokens));

	}

}
