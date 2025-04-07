package tuf_sde.binarytree3;

// https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
public class Symmetric_Tree {

	// Recursive helper function to check if two subtrees are mirror images
	static boolean isMirror(Node leftSub, Node rightSub) {

		// Both are null, so they are mirror images
		if (leftSub == null && rightSub == null)
			return true;

		// One of them is null, so they aren't mirror images
		if (leftSub == null || rightSub == null || leftSub.data != rightSub.data)
			return false;

		// Check if the subtrees are mirrors
		return isMirror(leftSub.left, rightSub.right) && isMirror(leftSub.right, rightSub.left);
	}

	static boolean isSymmetric(Node root) {
		// If tree is empty, it's symmetric
		if (root == null)
			return true;

		// Check if the left and right subtrees are mirrors of each other
		return isMirror(root.left, root.right);
	}

	public static void main(String[] args) {
		// Creating a sample symmetric binary tree
		// 1
		// / \
		// 2 2
		// / \ / \
		// 3 4 4 3
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		if (isSymmetric(root))
			System.out.println("true");
		else
			System.out.println("false");
	}

	static class Node {
		int data;
		Node left, right;

		Node(int val) {
			data = val;
			left = right = null;
		}
	}

}
