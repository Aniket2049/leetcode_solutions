package neetcode250.g_binarytree;

import java.util.HashMap;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// https://www.youtube.com/watch?v=aZNaLrVebKQ
public class _19_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	class TreeNode {
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

	private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			HashMap<Integer, Integer> inorderMap) {
		if (preStart < 0 || preEnd > preorder.length || inStart < 0 || inEnd > inorder.length || preStart > preEnd
				|| inStart > inEnd) {
			return null;
		}

		int rootVal = preorder[preStart];
		TreeNode root = new TreeNode(rootVal);
		int indexOfRootInInorder = inorderMap.get(rootVal);
		int lengthOfLeftSubTree = indexOfRootInInorder - inStart;

		root.left = buildTreeHelper(preorder, preStart + 1, preStart + lengthOfLeftSubTree, inorder, inStart,
				indexOfRootInInorder - 1, inorderMap);
		root.right = buildTreeHelper(preorder, preStart + lengthOfLeftSubTree + 1, preEnd, inorder,
				indexOfRootInInorder + 1, inEnd, inorderMap);

		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}

		return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
	}
}
