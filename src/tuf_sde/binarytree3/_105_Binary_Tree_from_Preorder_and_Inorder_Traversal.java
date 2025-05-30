package tuf_sde.binarytree3;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// https://www.youtube.com/watch?v=aZNaLrVebKQ
public class _105_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	// Function to build a binary tree
	// from preorder and inorder traversals
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Create a map to store indices
		// of elements in the inorder traversal
		Map<Integer, Integer> inMap = new HashMap<>();

		// Populate the map with indices
		// of elements in the inorder traversal
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		// Call the private helper function
		// to recursively build the tree
		TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

		return root;
	}

	// Recursive helper function to build the tree
	private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {
		// Base case: If the start indices
		// exceed the end indices, return null
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		// Create a new TreeNode with value
		// at the current preorder index
		TreeNode root = new TreeNode(preorder[preStart]);

		// Find the index of the current root
		// value in the inorder traversal
		int inRoot = inMap.get(root.val);

		// Calculate the number of
		// elements in the left subtree
		int numsLeft = inRoot - inStart;

		// Recursively build the left subtree
		root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);

		// Recursively build the right subtree
		root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

		// Return the current root node
		return root;
	}

	public static void main(String[] args) {
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };

		System.out.print("Inorder Vector: ");
		new _105_Binary_Tree_from_Preorder_and_Inorder_Traversal().printVector(inorder);

		System.out.print("Preorder Vector: ");
		new _105_Binary_Tree_from_Preorder_and_Inorder_Traversal().printVector(preorder);

		_105_Binary_Tree_from_Preorder_and_Inorder_Traversal sol = new _105_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		TreeNode root = sol.buildTree(preorder, inorder);

		System.out.println("Inorder of Unique Binary Tree Created:");
		sol.printInorder(root);
		System.out.println();

	}

	// Function to print the
	// inorder traversal of a tree
	private void printInorder(TreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.val + " ");
			printInorder(root.right);
		}
	}

	// Function to print the
	// given vector
	private void printVector(int[] vec) {
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i] + " ");
		}
		System.out.println();
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
