package tuf.binarysearchtree2;

// https://www.naukri.com/code360/problems/ceil-from-bst_920464
// https://www.youtube.com/watch?v=KSsk8AhdOZA
public class Ceil_in_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int ceilInBST(TreeNode root, int key) {
		int ceil = -1;
		while (root != null) {
			if (root.val == key) {
				ceil = root.val;
				return ceil;
			}

			if (key > root.val) {
				root = root.right;
			} else {
				ceil = root.val;
				root = root.left;
			}
		}

		return ceil;
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
