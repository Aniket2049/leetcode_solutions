package neetcode150.f_linkedlist;

// https://leetcode.com/problems/linked-list-cycle/
// https://www.youtube.com/watch?v=gBTe7lFR3vc
public class _3_141_LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
