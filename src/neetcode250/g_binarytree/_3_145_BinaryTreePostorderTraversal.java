package neetcode250.g_binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
// https://www.youtube.com/watch?v=ZIXGxg8ZLKs
public class _3_145_BinaryTreePostorderTraversal {
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

	public List<Integer> postorderTraversal(TreeNode root) {
		res = new ArrayList<>();
		postorder(root);
		return res;
	}

	private void postorder(TreeNode node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		res.add(node.val);
	}
}
