package tuf_sde.stack_queue2;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/description/
// https://www.youtube.com/watch?v=V09NfaGf2ao
public class _155_Min_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MinStack {

	Stack<Long> st = new Stack<Long>();
	Long mini;

	public MinStack() {
		mini = Long.MAX_VALUE;
	}

	public void push(int value) {
		Long val = Long.valueOf(value);
		if (st.isEmpty()) {
			mini = val;
			st.push(val);
		} else {
			if (val < mini) {
				st.push(2 * val - mini);
				mini = val;
			} else {
				st.push(val);
			}
		}
	}

	public void pop() {
		if (st.isEmpty())
			return;

		Long val = st.pop();
		if (val < mini) {
			mini = 2 * mini - val;
		}
	}

	public int top() {
		Long val = st.peek();
		if (val < mini) {
			return mini.intValue();
		}
		return val.intValue();
	}

	public int getMin() {
		return mini.intValue();
	}
}