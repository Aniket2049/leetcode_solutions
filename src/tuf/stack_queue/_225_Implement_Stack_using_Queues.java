package tuf.stack_queue;

import java.util.LinkedList;

// https://leetcode.com/problems/implement-stack-using-queues/description/
// https://www.youtube.com/watch?v=jDZQKzEtbYQ
public class _225_Implement_Stack_using_Queues {

	public static void main(String[] args) {
		stack s = new stack();
		s.push(3);
		s.push(2);
		s.push(4);
		s.push(1);
		System.out.println("Top of the stack: " + s.top());
		System.out.println("Size of the stack before removing element: " + s.size());
		System.out.println("The deleted element is: " + s.pop());
		System.out.println("Top of the stack after removing element: " + s.top());
		System.out.println("Size of the stack after removing element: " + s.size());

	}

}

class MyStack {

	LinkedList<Integer> q = new LinkedList<Integer>();

	public MyStack() {

	}

	public void push(int x) {
		q.add(x);
		for (int i = 0; i < q.size() - 1; i++) {
			q.add(q.remove());
		}
	}

	public int pop() {
		return q.remove();
	}

	public int top() {
		return q.peek();
	}

	public boolean empty() {
		return q.size() == 0;
	}
}