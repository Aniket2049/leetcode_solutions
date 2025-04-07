package tuf_sde.binarytree2;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// https://www.youtube.com/watch?v=eD3tmO66aBA
public class _104_Maximum_Depth_of_Binary_Tree {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int lH = maxDepth(root.left);
		int rH = maxDepth(root.right);

		return 1 + Math.max(lH, rH);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class TreeNode {
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
