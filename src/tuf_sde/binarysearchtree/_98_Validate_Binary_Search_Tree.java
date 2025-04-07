package tuf_sde.binarysearchtree;

// https://leetcode.com/problems/validate-binary-search-tree/description/
// https://www.youtube.com/watch?v=f-sj7I5oXEI
// https://www.youtube.com/watch?v=PITUkhnuWHQ
// https://leetcode.com/problems/validate-binary-search-tree/solutions/5622933/video-check-range-of-each-node/?source=submission-noac
public class _98_Validate_Binary_Search_Tree {

	public boolean isValidBST(TreeNode root) {
		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validate(TreeNode root, long minValue, long maxValue) {
		if (root == null)
			return true;
		if (!(root.val > minValue && root.val < maxValue))
			return false;

		return validate(root.left, minValue, root.val) && validate(root.right, root.val, maxValue);
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
