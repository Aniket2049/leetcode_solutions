package neetcode.binarytree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// https://www.youtube.com/watch?v=hTM3phVI6YQ
public class _2_104_MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
