package neetcode150.binarytree;

import java.util.HashMap;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// https://www.youtube.com/watch?v=PbPS460rbMo
// https://www.youtube.com/watch?v=aZNaLrVebKQ
public class _13_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			HashMap<Integer, Integer> inorderIndexMap) {
		if (preStart < 0 || preEnd > preorder.length || inStart < 0 || inEnd > inorder.length || preStart > preEnd
				|| inStart > inEnd) {
			return null;
		}

		int rootVal = preorder[preStart];
		TreeNode root = new TreeNode(rootVal);
		int indexOfRootInInorder = inorderIndexMap.get(rootVal);
		int lengthOfLeftSubTreeInInorder = indexOfRootInInorder - inStart;

		root.left = buildTreeHelper(preorder, preStart + 1, preStart + lengthOfLeftSubTreeInInorder, inorder, inStart,
				indexOfRootInInorder - 1, inorderIndexMap);
		root.right = buildTreeHelper(preorder, preStart + lengthOfLeftSubTreeInInorder + 1, preEnd, inorder,
				indexOfRootInInorder + 1, inEnd, inorderIndexMap);

		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> inorderIndexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
	}

	public static void main(String[] args) {

		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		new _13_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);

	}

	static class TreeNode {
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
