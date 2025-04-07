package tuf_sde.stack_queue;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
// https://www.youtube.com/watch?v=wkDfsKijrZ8
public class _20_Valid_Parentheses {

	public boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		for (char it : s.toCharArray()) {
			if (it == '(' || it == '[' || it == '{')
				st.push(it);
			else {
				if (st.isEmpty())
					return false;
				char ch = st.pop();
				if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{'))
					continue;
				else
					return false;
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "()"
//		Output: true
		System.out.println(new _20_Valid_Parentheses().isValid("()"));
//		Example 2:
//		Input: s = "()[]{}"
//		Output: true
		System.out.println(new _20_Valid_Parentheses().isValid("()[]{}"));
//		Example 3:
//		Input: s = "(]"
//		Output: false
		System.out.println(new _20_Valid_Parentheses().isValid("(]"));
//		Example 4:
//		Input: s = "([])"
//		Output: true
		System.out.println(new _20_Valid_Parentheses().isValid("([])"));
	}

}
