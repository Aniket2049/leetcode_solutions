package neetcode.linkedlist;

import java.util.HashMap;
import java.util.Map.Entry;

// https://leetcode.com/problems/copy-list-with-random-pointer/
// https://www.youtube.com/watch?v=5Y2EiZST97Y
public class _6_138_CopyListWithRandomPointer {

	public Node copyRandomList(Node head) {
		Node tempHead = head;
		HashMap<Node, Node> mainToNewMap = new HashMap<_6_138_CopyListWithRandomPointer.Node, _6_138_CopyListWithRandomPointer.Node>();

		while (tempHead != null) {
			Node newListNode = new Node(tempHead.val);
			mainToNewMap.put(tempHead, newListNode);
			tempHead = tempHead.next;
		}

		for (Entry<Node, Node> entry : mainToNewMap.entrySet()) {
			Node originalNode = entry.getKey();
			Node newNode = entry.getValue();

			newNode.next = mainToNewMap.get(originalNode.next);
			newNode.random = mainToNewMap.get(originalNode.random);
		}

		return mainToNewMap.get(head);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
