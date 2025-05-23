package neetcode250.g_binarytree;

// https://leetcode.com/problems/balanced-binary-tree/
// https://www.youtube.com/watch?v=BrnZDIoScEA
public class _7_110_BalancedBinaryTree {
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

	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;

		int leftHeight = height(node.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = height(node.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return 1 + Math.max(leftHeight, rightHeight);
	}
}
