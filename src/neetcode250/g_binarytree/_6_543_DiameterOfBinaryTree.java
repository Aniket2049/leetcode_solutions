package neetcode250.g_binarytree;

// https://leetcode.com/problems/diameter-of-binary-tree/
// https://www.youtube.com/watch?v=6lJZ_xj1mEo
public class _6_543_DiameterOfBinaryTree {
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

	public int diameterOfBinaryTree(TreeNode root) {
		int[] res = new int[1];
		dfs(root, res);
		return res[0];
	}

	private int dfs(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left, res);
		int right = dfs(root.right, res);
		res[0] = Math.max(res[0], left + right);
		return 1 + Math.max(left, right);
	}
}
