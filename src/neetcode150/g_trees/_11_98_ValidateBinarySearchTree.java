package neetcode150.g_trees;

// https://leetcode.com/problems/validate-binary-search-tree/description/
// https://www.youtube.com/watch?v=s6ATEkipzow
public class _11_98_ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean valid(TreeNode node, long left, long right) {
		if (node == null) {
			return true;
		}
		if (!(left < node.val && node.val < right)) {
			return false;
		}
		return valid(node.left, left, node.val) && valid(node.right, node.val, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
