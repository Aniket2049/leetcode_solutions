package tuf_sde.binarytree2;

// https://leetcode.com/problems/same-tree/
// https://www.youtube.com/watch?v=BhuvF_-PWS0
public class _100_Same_Tree {

	public boolean isSameTree(TreeNode node1, TreeNode node2) {
		// If both nodes are NULL,
		// they are identical
		if (node1 == null && node2 == null) {
			return true;
		}
		// If only one of the nodes is
		// NULL, they are not identical
		if (node1 == null || node2 == null) {
			return false;
		}
		// Check if the current nodes
		// have the same data value
		// and recursively check their
		// left and right subtrees
		return ((node1.val == node2.val) && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
}
