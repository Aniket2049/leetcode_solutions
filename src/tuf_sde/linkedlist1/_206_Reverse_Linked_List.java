package tuf_sde.linkedlist1;

// https://leetcode.com/problems/reverse-linked-list/description/
// https://www.youtube.com/watch?v=D2vI2DNJGd8
// https://www.youtube.com/watch?v=G0_I-ZF0S38
public class _206_Reverse_Linked_List {

	public ListNode reverseList(ListNode head) {
		ListNode temp = head;
		ListNode prev = null;
		while (temp != null) {
			ListNode front = temp.next;
			temp.next = prev;
			prev = temp;
			temp = front;
		}

		return prev;
	}

	public ListNode reverseListRecursive(ListNode head) {
        // Base case:
        // If the linked list is empty or has only one node,
        // return the head as it is already reversed.
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive step:
        // Reverse the linked list starting
        // from the second node (head.next).
        ListNode newHead = reverseListRecursive(head.next);
        
        // Save a reference to the node following
        // the current 'head' node.
        ListNode front = head.next;
        
        // Make the 'front' node point to the current
        // 'head' node in the reversed order.
        front.next = head;
        
        // Break the link from the current 'head' node
        // to the 'front' node to avoid cycles.
        head.next = null;
        
        // Return the 'newHead,' which is the new
        // head of the reversed linked list.
        return newHead;
    }
	
	public static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [1,2,3,4,5]
//		Output: [5,4,3,2,1]
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		printList(new _206_Reverse_Linked_List().reverseList(node1));

//		Example 2:
//		Input: head = [1,2]
//		Output: [2,1]
		node1 = new ListNode(11);
		node2 = new ListNode(22);
		node3 = new ListNode(33);
		node4 = new ListNode(44);
		node5 = new ListNode(55);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		printList(new _206_Reverse_Linked_List().reverseListRecursive(node1));


//		Example 3:
//		Input: head = []
//		Output: []

	}

}
