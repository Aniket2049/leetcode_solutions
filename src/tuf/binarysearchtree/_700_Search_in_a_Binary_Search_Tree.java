package tuf.binarysearchtree;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
// https://www.youtube.com/watch?v=KcNt6v_56cc
public class _700_Search_in_a_Binary_Search_Tree {

	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null && root.val != val) {
			root = val < root.val ? root.left : root.right;
		}
		return root;
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
