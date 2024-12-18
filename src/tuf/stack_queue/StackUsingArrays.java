package tuf.stack_queue;

// https://takeuforward.org/data-structure/implement-stack-using-array/
// https://www.geeksforgeeks.org/problems/implement-stack-using-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-stack-using-array
// https://www.youtube.com/watch?v=GYptUgnIM_I
public class StackUsingArrays {

	public static void main(String[] args) {
		stack s = new stack();
		s.push(6);
		s.push(3);
		s.push(7);
		System.out.println("Top of the stack before deleting any element " + s.top());
		System.out.println("Size of the stack before deleting any element " + s.size());
		System.out.println("The element deleted is " + s.pop());
		System.out.println("Size of the stack after deleting an element " + s.size());
		System.out.println("Top of the stack after deleting an element " + s.top());
	}

}

class stack {
	int size = 10000;
	int arr[] = new int[size];
	int top = -1;

	void push(int x) {
		top++;
		arr[top] = x;
	}

	int pop() {
		int x = arr[top];
		top--;
		return x;
	}

	int top() {
		return arr[top];
	}

	int size() {
		return top + 1;
	}
}