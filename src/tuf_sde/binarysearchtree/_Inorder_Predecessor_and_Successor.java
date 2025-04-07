package tuf_sde.binarysearchtree;

// https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
// https://www.youtube.com/watch?v=SXKAD2svfmI
public class _Inorder_Predecessor_and_Successor {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode successor = null;
		while (root != null) {
			if (p.val >= root.val) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}

	public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		TreeNode predecessor = null;
		while (root != null) {
			if (p.val <= root.val) {
				root = root.left;
			} else {
				predecessor = root;
				root = root.right;
			}
		}
		return predecessor;
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
