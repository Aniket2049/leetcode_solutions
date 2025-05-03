package neetcode250.g_binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
// https://www.youtube.com/watch?v=WZulSX1plzE
public class _1_94_BinaryTreeInorderTraversal {
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

	private List<Integer> res;
	
	public List<Integer> inorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		inorder(root);
		return res;
	}

	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		res.add(node.val);
		inorder(node.right);
	}
}
