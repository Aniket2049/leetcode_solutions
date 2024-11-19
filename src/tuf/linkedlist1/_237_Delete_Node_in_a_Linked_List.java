package tuf.linkedlist1;

// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
// https://leetcode.com/problems/delete-node-in-a-linked-list/solutions/5113147/detailed-explanation-extremely-simple-1-2-liner-o-1-time-and-space-complexity/
public class _237_Delete_Node_in_a_Linked_List {

	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [4,5,1,9], node = 5
//		Output: [4,1,9]
//		Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

		ListNode node11 = new ListNode(4);
		ListNode node12 = new ListNode(5);
		ListNode node13 = new ListNode(1);
		ListNode node14 = new ListNode(9);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		
		
//		Example 2:
//		Input: head = [4,5,1,9], node = 1
//		Output: [4,5,9]
//		Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

	}

}
