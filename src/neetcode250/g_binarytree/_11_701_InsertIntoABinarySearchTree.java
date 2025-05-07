package neetcode250.g_binarytree;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// https://www.youtube.com/watch?v=Cpg8f79luEA
public class _11_701_InsertIntoABinarySearchTree {
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

	public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		} else {
			root.left = insertIntoBST(root.left, val);
		}

		return root;
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		TreeNode cur = root;
		while (true) {
			if (val > cur.val) {
				if (cur.right == null) {
					cur.right = new TreeNode(val);
					return root;
				}
				cur = cur.right;
			} else {
				if (cur.left == null) {
					cur.left = new TreeNode(val);
					return root;
				}
				cur = cur.left;
			}
		}
	}
}
