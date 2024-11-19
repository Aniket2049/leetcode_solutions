package tuf.linkedlist1;

// https://leetcode.com/problems/merge-two-sorted-lists/description/
// https://www.youtube.com/watch?v=jXu-H7XuClE
public class _21_Merge_Two_Sorted_Lists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode t1 = list1;
		ListNode t2 = list2;
		ListNode t3 = new ListNode();
		ListNode temp = t3;

		while (t1 != null && t2 != null) {
			if (t1.val < t2.val) {
				temp.next = t1;
				temp = t1;
				t1 = t1.next;
			} else {
				temp.next = t2;
				temp = t2;
				t2 = t2.next;
			}
		}

		if (t1 != null) {
			temp.next = t1;
		} else {
			temp.next = t2;
		}

		return t3.next;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: list1 = [1,2,4], list2 = [1,3,4]
//		Output: [1,1,2,3,4,4]
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(4);
		node11.next = node12;
		node12.next = node13;
		ListNode node21 = new ListNode(1);
		ListNode node22 = new ListNode(3);
		ListNode node23 = new ListNode(4);
		node21.next = node22;
		node22.next = node23;

		printList(new _21_Merge_Two_Sorted_Lists().mergeTwoLists(node11, node21));

//		Example 2:
//		Input: list1 = [], list2 = []
//		Output: []
		node11 = null;
		node21 = null;
		printList(new _21_Merge_Two_Sorted_Lists().mergeTwoLists(node11, node21));

//		Example 3:
//		Input: list1 = [], list2 = [0]
//		Output: [0]
		node11 = null;
		node21 = new ListNode(0);
		printList(new _21_Merge_Two_Sorted_Lists().mergeTwoLists(node11, node21));

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
