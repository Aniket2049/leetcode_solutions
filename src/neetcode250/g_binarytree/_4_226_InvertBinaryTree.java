package neetcode250.g_binarytree;

// https://leetcode.com/problems/invert-binary-tree/
// https://www.youtube.com/watch?v=ck23lNqbLjI
public class _4_226_InvertBinaryTree {
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

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}
