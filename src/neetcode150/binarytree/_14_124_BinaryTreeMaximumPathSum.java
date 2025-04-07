package neetcode150.binarytree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// https://www.youtube.com/watch?v=Hr5cWUld4vU
public class _14_124_BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
		int[] res = new int[] { root.val };
		dfs(root, res);
		return res[0];
	}

	private int dfs(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}

		int leftMax = Math.max(dfs(root.left, res), 0);
		int rightMax = Math.max(dfs(root.right, res), 0);

		res[0] = Math.max(res[0], root.val + leftMax + rightMax);
		return root.val + Math.max(leftMax, rightMax);
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
