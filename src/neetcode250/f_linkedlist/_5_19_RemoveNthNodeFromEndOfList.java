package neetcode250.f_linkedlist;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// https://www.youtube.com/watch?v=6gI8OMoac4Q
public class _5_19_RemoveNthNodeFromEndOfList {
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode firstPtr = dummy;
		ListNode secondPtr = dummy;

		// Move secondPtr n spaces ahead
		for (int i = 0; i < n; i++) {
			secondPtr = secondPtr.next;
		}

		// Move both now, until the next of secondPtr is null
		while (secondPtr.next != null) {
			firstPtr = firstPtr.next;
			secondPtr = secondPtr.next;
		}

		// We now have to remove the node next of firstPtr
		firstPtr.next = firstPtr.next.next;

		return dummy.next;
	}
}
