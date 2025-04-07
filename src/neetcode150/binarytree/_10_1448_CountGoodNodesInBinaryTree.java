package neetcode150.binarytree;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
// https://www.youtube.com/watch?v=7cp5imvDzl4
public class _10_1448_CountGoodNodesInBinaryTree {

	public int goodNodes(TreeNode root) {
		return dfs(root, root.val);
	}

	private int dfs(TreeNode node, int maxVal) {
		if (node == null) {
			return 0;
		}

		int res = (node.val >= maxVal) ? 1 : 0;
		maxVal = Math.max(maxVal, node.val);
		res += dfs(node.left, maxVal);
		res += dfs(node.right, maxVal);
		return res;
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
