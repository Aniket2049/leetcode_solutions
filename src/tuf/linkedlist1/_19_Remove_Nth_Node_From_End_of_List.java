package tuf.linkedlist1;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// https://www.youtube.com/watch?v=3kMKYQ2wNIU
public class _19_Remove_Nth_Node_From_End_of_List {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Create two pointers, fastp and slowp
		ListNode fastp = head;
		ListNode slowp = head;

        // Move the fastp pointer N nodes ahead
        for (int i = 0; i < n; i++)
            fastp = fastp.next;

        // If fastp becomes null, the Nth node from the end is the head
        if (fastp == null)
            return head.next;

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        ListNode delNode = slowp.next;
        slowp.next = slowp.next.next;
        delNode = null;
        return head;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [1,2,3,4,5], n = 2
//		Output: [1,2,3,5]
		int n = 2;
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		printList(new _19_Remove_Nth_Node_From_End_of_List().removeNthFromEnd(node1,n));
		
//		Example 2:
//		Input: head = [1], n = 1
//		Output: []
		n = 1;
		node1 = new ListNode(1);
		printList(new _19_Remove_Nth_Node_From_End_of_List().removeNthFromEnd(node1,n));


//		Example 3:
//		Input: head = [1,2], n = 1
//		Output: [1]
		n = 1;
		node1 = new ListNode(1);
		node2 = new ListNode(2);
		node1.next = node2;
		printList(new _19_Remove_Nth_Node_From_End_of_List().removeNthFromEnd(node1,n));


	}

	public static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
