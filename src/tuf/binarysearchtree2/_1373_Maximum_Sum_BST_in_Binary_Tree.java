package tuf.binarysearchtree2;

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
// https://www.youtube.com/watch?v=HbDX8aPMc00
public class _1373_Maximum_Sum_BST_in_Binary_Tree {

	int result = Integer.MIN_VALUE;

	public int maxSumBST(TreeNode root) {
		helper(root);
		return result < 0 ? 0 : result;
	}

	// res[0] min value
	// res[1] max value
	// res[2] sum value
	private int[] helper(TreeNode root) {
		if (root == null) {
			return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
		}

		int[] left = helper(root.left);
		int[] right = helper(root.right);

		if (left[1] >= root.val || right[0] <= root.val) {
			return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };
		}

		int sum = left[2] + root.val + right[2];
		result = Math.max(result, sum);
		return new int[] { Math.min(root.val, left[0]), Math.max(root.val, right[1]), sum };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
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
