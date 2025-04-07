package tuf_sde.linkedlist1;

// https://leetcode.com/problems/add-two-numbers/description/
// https://www.youtube.com/watch?v=wgFPrzTjm7s
public class _2_Add_Two_Numbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;

		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int v1 = (l1 != null) ? l1.val : 0;
			int v2 = (l2 != null) ? l2.val : 0;

			int val = v1 + v2 + carry;
			carry = val / 10;
			val = val % 10;
			cur.next = new ListNode(val);

			cur = cur.next;
			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: l1 = [2,4,3], l2 = [5,6,4]
//		Output: [7,0,8]
//		Explanation: 342 + 465 = 807.

		ListNode node11 = new ListNode(2);
		ListNode node12 = new ListNode(4);
		ListNode node13 = new ListNode(3);
		node11.next = node12;
		node12.next = node13;
		ListNode node21 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node23 = new ListNode(4);
		node21.next = node22;
		node22.next = node23;
		printList(new _2_Add_Two_Numbers().addTwoNumbers(node11, node21));

//		Example 2:
//		Input: l1 = [0], l2 = [0]
//		Output: [0]

		node11 = new ListNode(0);
		node21 = new ListNode(0);
		printList(new _2_Add_Two_Numbers().addTwoNumbers(node11, node21));

//		Example 3:
//		Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//		Output: [8,9,9,9,0,0,0,1]
		node11 = new ListNode(9);
		node12 = new ListNode(9);
		node13 = new ListNode(9);
		ListNode node14 = new ListNode(9);
		ListNode node15 = new ListNode(9);
		ListNode node16 = new ListNode(9);
		ListNode node17 = new ListNode(9);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
		node16.next = node17;

		node21 = new ListNode(9);
		node22 = new ListNode(9);
		node23 = new ListNode(9);
		ListNode node24 = new ListNode(9);
		node21.next = node22;
		node22.next = node23;
		node23.next = node24;
		printList(new _2_Add_Two_Numbers().addTwoNumbers(node11, node21));


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
