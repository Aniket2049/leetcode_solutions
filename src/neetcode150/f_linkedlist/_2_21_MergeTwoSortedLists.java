package neetcode150.f_linkedlist;

// https://leetcode.com/problems/merge-two-sorted-lists/description/
// https://www.youtube.com/watch?v=XIdigk956u0
public class _2_21_MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				node.next = list1;
				list1 = list1.next;
			} else {
				node.next = list2;
				list2 = list2.next;
			}
			node = node.next;
		}

		if (list1 != null) {
			node.next = list1;
		} else {
			node.next = list2;
		}

		return dummy.next;
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
