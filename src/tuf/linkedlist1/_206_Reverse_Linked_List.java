package tuf.linkedlist1;

// https://leetcode.com/problems/reverse-linked-list/description/
// https://www.youtube.com/watch?v=D2vI2DNJGd8
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

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [1,2,3,4,5]
//		Output: [5,4,3,2,1]
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next= node2;
		node2.next= node3;
		node3.next= node4;
		node4.next= node5;
		
//		Example 2:
//		Input: head = [1,2]
//		Output: [2,1]

//		Example 3:
//		Input: head = []
//		Output: []

	}

}
