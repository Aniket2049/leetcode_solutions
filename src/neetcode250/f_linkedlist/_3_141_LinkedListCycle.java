package neetcode250.f_linkedlist;

// https://leetcode.com/problems/linked-list-cycle/
// https://www.youtube.com/watch?v=OQtvTZxA7-k
public class _3_141_LinkedListCycle {
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

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}
		}

		return false;
	}
}
