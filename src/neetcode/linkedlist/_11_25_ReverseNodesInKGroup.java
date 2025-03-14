package neetcode.linkedlist;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// 
public class _11_25_ReverseNodesInKGroup {

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

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode temp = new _11_25_ReverseNodesInKGroup().reverseKGroup(node1, 2);
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

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
