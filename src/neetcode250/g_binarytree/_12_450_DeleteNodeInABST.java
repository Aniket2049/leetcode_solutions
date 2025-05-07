package neetcode250.g_binarytree;

// https://leetcode.com/problems/delete-node-in-a-bst/
// https://www.youtube.com/watch?v=LFzAoJJt92M
public class _12_450_DeleteNodeInABST {
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

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;

		if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			TreeNode cur = root.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			root.val = cur.val;
			root.right = deleteNode(root.right, root.val);
		}

		return root;
	}
}
