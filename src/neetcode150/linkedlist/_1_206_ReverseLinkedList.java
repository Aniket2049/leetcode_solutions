package neetcode150.linkedlist;

// https://leetcode.com/problems/reverse-linked-list/description/
// https://www.youtube.com/watch?v=G0_I-ZF0S38
public class _1_206_ReverseLinkedList {

	public ListNode reverseListIterative(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public ListNode reverseListRecursive(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode newHead = head;
		if (head.next != null) {
			newHead = reverseListRecursive(head.next);
			head.next.next = head;
		}
		head.next = null;

		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class ListNode {
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
}
