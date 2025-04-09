package neetcode150.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/
// https://www.youtube.com/watch?v=qkLl7nAwDPo
public class _2_155_MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int val) {
		stack.push(val);
		int minVal;
		if (!minStack.isEmpty()) {
			minVal = minStack.getLast();
		} else {
			minVal = val;
		}
		minStack.push(Math.min(val, minVal));
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}