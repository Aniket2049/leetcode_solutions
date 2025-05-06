package neetcode250.g_binarytree;

// https://leetcode.com/problems/subtree-of-another-tree/
// https://www.youtube.com/watch?v=GZ8g8KdavUo
// https://www.youtube.com/watch?v=E36O5SWp-LE
public class _9_572_SubtreeOfAnotherTree {
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

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (subRoot == null) {
			return true;
		}
		if (root == null) {
			return false;
		}

		if (sameTree(root, subRoot)) {
			return true;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean sameTree(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}
		if (root != null && subRoot != null && root.val == subRoot.val) {
			return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
		}
		return false;
	}
}
