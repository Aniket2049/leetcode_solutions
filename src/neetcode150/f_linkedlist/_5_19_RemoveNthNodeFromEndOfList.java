package neetcode150.f_linkedlist;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// 
public class _5_19_RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy           = new ListNode(0, head);
        ListNode trailingPointer = dummy;
        ListNode leadingPointer  = head;
        
        while(leadingPointer != null && n > 0)
        {
            leadingPointer = leadingPointer.next;
            n--;
        }
        
        while(leadingPointer != null)
        {
            leadingPointer  = leadingPointer.next;
            trailingPointer = trailingPointer.next;
        }
        
        trailingPointer.next = trailingPointer.next.next;
        
        return dummy.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		node1 = new _5_19_RemoveNthNodeFromEndOfList().removeNthFromEnd(node1, 2);

		ListNode temp = node1;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
