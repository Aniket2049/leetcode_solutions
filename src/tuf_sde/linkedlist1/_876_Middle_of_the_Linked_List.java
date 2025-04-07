package tuf_sde.linkedlist1;

// https://leetcode.com/problems/middle-of-the-linked-list/description/
// https://www.youtube.com/watch?v=7LjQ57RqgEc
public class _876_Middle_of_the_Linked_List {

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [1,2,3,4,5]
//		Output: [3,4,5]
//		Explanation: The middle node of the list is node 3.

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		printList(new _876_Middle_of_the_Linked_List().middleNode(node1));

//		Example 2:
//		Input: head = [1,2,3,4,5,6]
//		Output: [4,5,6]
//		Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

		node1 = new ListNode(11);
		node2 = new ListNode(22);
		node3 = new ListNode(33);
		node4 = new ListNode(44);
		node5 = new ListNode(55);
		ListNode node6 = new ListNode(66);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		printList(new _876_Middle_of_the_Linked_List().middleNode(node1));

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
