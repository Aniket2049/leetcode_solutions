package neetcode150.stack;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
// https://www.youtube.com/watch?v=WTzjTskDFMg
public class _1_20_ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		java.util.Map<Character, Character> closeToOpen = new java.util.HashMap<>();
		closeToOpen.put(')', '(');
		closeToOpen.put(']', '[');
		closeToOpen.put('}', '{');

		for (char c : s.toCharArray()) {
			if (closeToOpen.containsKey(c)) {
				if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new _1_20_ValidParentheses().isValid("()"));
		System.out.println(new _1_20_ValidParentheses().isValid("()]"));
		System.out.println(new _1_20_ValidParentheses().isValid("{()[]}"));

	}

}
