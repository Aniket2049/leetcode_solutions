package neetcode150.f_linkedlist;

// https://leetcode.com/problems/reorder-list/description/
// 
public class _4_143_ReorderList {

	public static ListNode reverseListIterative(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public void reorderList(ListNode head) {
        ListNode fast       = head;
        ListNode slow       = head;
        ListNode secondHead = head;
        ListNode prevOfSlow = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            prevOfSlow = slow;
            fast       = fast.next.next;
            slow       = slow.next;
        }
        
        if(fast.next != null) // even numbers in list
        {
            secondHead = slow.next;
            fast       = fast.next;
            slow.next  = null;
        }
        else // odd numbers in list
        {
            secondHead = slow.next;
            slow.next = null;
        }
        
        secondHead = reverseListIterative(secondHead);

		ListNode firstTemp = head;
		ListNode secondTemp = secondHead;
		while (secondTemp != null) {
			ListNode firstNext = firstTemp.next;
			ListNode secondNodeToInsert = secondTemp;
			secondTemp = secondTemp.next;

			firstTemp.next = secondNodeToInsert;
			secondNodeToInsert.next = firstNext;
			firstTemp = firstTemp.next.next;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
