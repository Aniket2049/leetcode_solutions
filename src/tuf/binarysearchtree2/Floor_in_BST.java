package tuf.binarysearchtree2;

// https://www.naukri.com/code360/problems/floor-from-bst_920457
// https://www.youtube.com/watch?v=xm_W1ub-K-w
public class Floor_in_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int floorInBST(TreeNode root, int key) {
		int floor = -1;
		while (root != null) {
			if (root.val == key) {
				floor = root.val;
				return floor;
			}

			if (key > root.val) {
				floor = root.val;
				root = root.right;
			} else {
				root = root.left;
			}
		}

		return floor;
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
