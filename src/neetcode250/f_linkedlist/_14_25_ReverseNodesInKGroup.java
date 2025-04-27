package neetcode250.f_linkedlist;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
// 
public class _14_25_ReverseNodesInKGroup {
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

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode left = dummy;
		ListNode right = dummy.next; // head
		ListNode prevRight = dummy;

		while (right != null) {
			int currentGroupK = k;
			while (currentGroupK > 0 && right != null) {
				prevRight = right;
				right = right.next;
				currentGroupK--;
			}

			if (currentGroupK == 0) {
				prevRight.next = null;
				ListNode reversed = reverseListIterative(left.next);
				left.next = reversed;
				while (left.next != null) {
					left = left.next;
				}

				left.next = right;
			}

		}

		return dummy.next;
	}
}
