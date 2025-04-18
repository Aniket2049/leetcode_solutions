package neetcode250.d_stack;

import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
// https://www.youtube.com/watch?v=WTzjTskDFMg
public class _2_20_ValidParentheses {
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new java.util.HashMap<>();
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
}
