package neetcode250.g_binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
// https://www.youtube.com/watch?v=Ifj-2aqSMnE
public class _2_144_BinaryTreePreorderTraversal {
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

	public List<Integer> preorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		preorder(root);
		return res;
	}

	private void preorder(TreeNode node) {
		if (node == null) {
			return;
		}
		res.add(node.val);
		preorder(node.left);
		preorder(node.right);
	}
}
