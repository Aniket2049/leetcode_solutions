package neetcode250.d_stack;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/
// https://www.youtube.com/watch?v=Eh2gTUHL8Hs
public class _3_225_ImplementStackUsingQueues {
	class MyStack {
		private Queue<Integer> queue;

		public MyStack() {
		    queue = new LinkedList<>();
		  }

		  public void push(int x) {
		    queue.add(x);
		    for (int i = 1; i < queue.size(); i++)
		      queue.add(queue.remove());

		  }

		  public int pop() {
		    return queue.remove();
		  }

		  public int top() {
		    return queue.peek();
		  }

		  public boolean empty() {
		    return queue.isEmpty();
		  }
	}
}
