package neetcode250.g_binarytree;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// https://www.youtube.com/watch?v=PwjF3RO9djY
public class _18_230_KthSmallestElementInABST {
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

	private int count;
	private int ans;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		ans = 0;
		dfs(root);
		return ans;
	}

	private void dfs(TreeNode node) {
		if (node == null) {
			return;
		}

		dfs(node.left);

		if (count == 1) {
			ans = node.val;
		}

		count--;
		if (count > 0) {
			dfs(node.right);
		}
	}
}
