package tuf_sde.linkedlistarrays;

import tuf_sde.linkedlist1.ListNode;

// https://leetcode.com/problems/rotate-list/description/
// https://www.youtube.com/watch?v=9VPm6nEbVPA
public class _61_Rotate_List {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;

		ListNode current = head;
		int length = 1;
		while (current.next != null) {
			length++;
			current = current.next;
		}

		current.next = head;
		k = length - k % length;

		while (k-- > 0)
			current = current.next;

		head = current.next;
		current.next = null;

		return head;

	}

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [1,2,3,4,5], k = 2
//		Output: [4,5,1,2,3]

//		Example 2:
//		Input: head = [0,1,2], k = 4
//		Output: [2,0,1]

	}

}
