package neetcode250.q_math;

// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
// https://www.youtube.com/watch?v=SS_IlBrocYQ
public class _03_2807_InsertGreatestCommonDivisorsInLinkedList {
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

	public ListNode insertGreatestCommonDivisors(ListNode head) {
		if (head == null)
			return null;

		ListNode cur = head;

		while (cur.next != null) {
			int n1 = cur.val, n2 = cur.next.val;
			int gcdValue = gcd(n1, n2);
			ListNode newNode = new ListNode(gcdValue, cur.next);
			cur.next = newNode;
			cur = newNode.next;
		}

		return head;
	}

	private int gcd(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
