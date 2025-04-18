package neetcode150.g_trees;

// https://leetcode.com/problems/invert-binary-tree/description/
// 
public class _1_226_InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;

		if (root.left != null) {
			invertTree(root.left);
		}
		if (root.right != null) {
			invertTree(root.right);
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		return root;
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
