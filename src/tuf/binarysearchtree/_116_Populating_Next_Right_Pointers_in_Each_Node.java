package tuf.binarysearchtree;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
// https://www.youtube.com/watch?v=U4hFQCa1Cq0
public class _116_Populating_Next_Right_Pointers_in_Each_Node {

	public Node connect(Node root) {
		if(root == null) return root;
		Node current = root;
		Node next;
		if (root.left != null) {
			next = root.left;
		} else {
			next = null;
		}

		while (current != null && next != null) {
			current.left.next = current.right;
			if (current.next != null)
				current.right.next = current.next.left;

			current = current.next;
			if (current == null) {
				current = next;
				next = current.left;
			}

		}

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

}
