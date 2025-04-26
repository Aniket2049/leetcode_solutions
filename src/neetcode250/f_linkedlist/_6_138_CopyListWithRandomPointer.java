package neetcode250.f_linkedlist;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
// https://www.youtube.com/watch?v=5Y2EiZST97Y
public class _6_138_CopyListWithRandomPointer {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		Map<Node, Node> oldToCopy = new HashMap<>();
		oldToCopy.put(null, null);

		Node cur = head;
		while (cur != null) {
			Node copy = new Node(cur.val);
			oldToCopy.put(cur, copy);
			cur = cur.next;
		}

		cur = head;
		while (cur != null) {
			Node copy = oldToCopy.get(cur);
			copy.next = oldToCopy.get(cur.next);
			copy.random = oldToCopy.get(cur.random);
			cur = cur.next;
		}

		return oldToCopy.get(head);
	}
}
