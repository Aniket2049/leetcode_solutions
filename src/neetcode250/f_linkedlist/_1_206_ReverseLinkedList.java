package neetcode250.f_linkedlist;

// https://leetcode.com/problems/reverse-linked-list/
// https://www.youtube.com/watch?v=3IN0BP9Ni6E
public class _1_206_ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}
}
