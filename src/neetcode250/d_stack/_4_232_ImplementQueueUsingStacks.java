package neetcode250.d_stack;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
// https://www.youtube.com/watch?v=0ZUM0yhBtPI
public class _4_232_ImplementQueueUsingStacks {
	class MyQueue {
		private final Stack<Integer> input;
		private final Stack<Integer> output;

		public MyQueue() {
			input = new Stack<>();
			output = new Stack<>();
		}

		public void push(int x) {
			input.push(x);
		}

		public int pop() {
			peek();
			return output.pop();
		}

		public int peek() {
			if (output.empty())
				while (!input.empty())
					output.push(input.pop());
			return output.peek();
		}

		public boolean empty() {
			return input.empty() && output.empty();
		}
	}
}
