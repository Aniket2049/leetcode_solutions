package tuf.linkedlist2;

import tuf.linkedlist1.ListNode;

// https://leetcode.com/problems/linked-list-cycle/description/
// https://www.youtube.com/watch?v=wiOo4DC5GGA
public class _141_Linked_List_Cycle {

	public boolean hasCycle(ListNode head) {
		// Initialize two pointers, slow and fast,
		// to the head of the linked list
		ListNode slow = head;
		ListNode fast = head;

		// Step 2: Traverse the linked list
		// with the slow and fast pointers
		while (fast != null && fast.next != null) {
			// Move slow one step
			slow = slow.next;
			// Move fast two steps
			fast = fast.next.next;

			// Check if slow and fast pointers meet
			if (slow == fast) {
				return true; // Loop detected
			}
		}

		// If fast reaches the end of the
		// list, there is no loop
		return false;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [3,2,0,-4], pos = 1
//		Output: true
//		Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

//		Example 2:
//		Input: head = [1,2], pos = 0
//		Output: true
//		Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

//		Example 3:
//		Input: head = [1], pos = -1
//		Output: false
//		Explanation: There is no cycle in the linked list.

	}

}
