package neetcode150.f_linkedlist;

// https://leetcode.com/problems/add-two-numbers/description/
// https://www.youtube.com/watch?v=KMS0WFxrsT8
public class _7_2_AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode ptr = result;

		int carry = 0;    // Set default carry

		while (l1 != null || l2 != null) {
			int sum = 0 + carry;    // Initialize sum
			if (l1 != null) {    // Use number from first list
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {    // Use number from 2nd list
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;    // Get sum and carry
			sum = sum % 10;
			ptr.next = new ListNode(sum);
			ptr = ptr.next;
		}

		if (carry == 1)
			ptr.next = new ListNode(1);

		return result.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;

		ListNode m1 = new ListNode(5);
		ListNode m2 = new ListNode(6);
		ListNode m3 = new ListNode(7);
		m1.next = m2;
		m2.next = m3;

		ListNode res = new _7_2_AddTwoNumbers().addTwoNumbers(n1, m1);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
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
