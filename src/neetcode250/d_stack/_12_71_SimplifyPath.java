package neetcode250.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/
// https://www.youtube.com/watch?v=qYlHrAKJfyA
public class _12_71_SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path.split("/");

		for (String cur : paths) {
			if (cur.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else if (!cur.equals("") && !cur.equals(".")) {
				stack.push(cur);
			}
		}

		return "/" + String.join("/", stack);
	}
}
