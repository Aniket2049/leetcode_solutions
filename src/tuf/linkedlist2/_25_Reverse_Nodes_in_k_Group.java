package tuf.linkedlist2;

import tuf.linkedlist1.ListNode;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// https://www.youtube.com/watch?v=lIar1skcQYI
// https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/6045778/java-easy-sol-o-n-beats-100/
public class _25_Reverse_Nodes_in_k_Group {

	// Function to reverse a linked list
	// using the 3-pointer approach
	static ListNode reverseLinkedList(ListNode head) {
		// Initialize'temp' at
		// head of linked list
		ListNode temp = head;

		// Initialize pointer 'prev' to NULL,
		// representing the previous node
		ListNode prev = null;

		// Traverse the list, continue till
		// 'temp' reaches the end (NULL)
		while (temp != null) {
			// Store the next node in
			// 'front' to preserve the reference
			ListNode front = temp.next;

			// Reverse the direction of the
			// current node's 'next' pointer
			// to point to 'prev'
			temp.next = prev;

			// Move 'prev' to the current
			// node for the next iteration
			prev = temp;

			// Move 'temp' to the 'front' node
			// advancing the traversal
			temp = front;
		}

		// Return the new head of
		// the reversed linked list
		return prev;

	}

	// Function to get the Kth node from
	// a given position in the linked list
	static ListNode getKthNode(ListNode temp, int k) {
		// Decrement K as we already
		// start from the 1st node
		k -= 1;

		// Decrement K until it reaches
		// the desired position
		while (temp != null && k > 0) {
			// Decrement k as temp progresses
			k--;

			// Move to the next node
			temp = temp.next;
		}

		// Return the Kth node
		return temp;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		// Initialize a temporary
		// node to traverse the list
		ListNode temp = head;

		// Initialize a pointer to track the
		// last node of the previous group
		ListNode prevLast = null;

		// Traverse through the linked list
		while (temp != null) {

			// Get the Kth node of the current group
			ListNode kThNode = getKthNode(temp, k);

			// If the Kth node is NULL
			// (not a complete group)
			if (kThNode == null) {

				// If there was a previous group,
				// link the last node to the current node
				if (prevLast != null) {
					prevLast.next = temp;
				}

				// Exit the loop
				break;
			}

			// Store the next node
			// after the Kth node
			ListNode nextNode = kThNode.next;

			// Disconnect the Kth node
			// to prepare for reversal
			kThNode.next = null;

			// Reverse the nodes from
			// temp to the Kth node
			reverseLinkedList(temp);

			// Adjust the head if the reversal
			// starts from the head
			if (temp == head) {
				head = kThNode;
			} else {
				// Link the last node of the previous
				// group to the reversed group
				prevLast.next = kThNode;
			}

			// Update the pointer to the
			// last node of the previous group
			prevLast = temp;

			// Move to the next group
			temp = nextNode;
		}

		// Return the head of the
		// modified linked list
		return head;
	}

	public static ListNode reverseKGroup2(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
            return head;
        }

        // Check if there are at least k nodes left to reverse
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        
        // If there are fewer than k nodes left, don't reverse
        if (count < k) {
            return head;
        }

        // Reverse the first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt;
        
        count = 0;
        while (count < k && curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            count++;
        }

        // Recursively reverse the next group of k nodes
        if (curr != null) {
            head.next = reverseKGroup(curr, k);
        }

        // prev is the new head of the reversed k nodes
        return prev;
	}
	public static void main(String[] args) {
//		Example 1:
//		Input: head = [1,2,3,4,5], k = 2
//		Output: [2,1,4,3,5]

		ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseKGroup2(head, 2);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
        
        System.out.println();
        
//		Example 2:
//		Input: head = [1,2,3,4,5], k = 3
//		Output: [3,2,1,4,5]

		head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseKGroup2(head, 3);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
	}
	
	static void printLinkedList(ListNode head) {
		ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
