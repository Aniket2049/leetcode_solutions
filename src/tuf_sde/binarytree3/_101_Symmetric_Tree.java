package tuf_sde.binarytree3;

// https://leetcode.com/problems/symmetric-tree/description/
// https://www.youtube.com/watch?v=nKggNAiEpBE
public class _101_Symmetric_Tree {

	// Function to check if
	// two subtrees are symmetric
	private boolean isSymmetricUtil(TreeNode root1, TreeNode root2) {
		// Check if either subtree is null
		if (root1 == null || root2 == null) {
			// If one subtree is null, the other
			// must also be null for symmetry
			return root1 == root2;
		}
		// Check if the data in the current nodes is equal
		// and recursively check for symmetry in subtrees
		return (root1.val == root2.val) && isSymmetricUtil(root1.left, root2.right)
				&& isSymmetricUtil(root1.right, root2.left);
	}

	// Public function to check if the
	// entire binary tree is symmetric
	public boolean isSymmetric(TreeNode root) {
		// Check if the tree is empty
		if (root == null) {
			// An empty tree is
			// considered symmetric
			return true;
		}
		// Call the utility function
		// to check symmetry of subtrees
		return isSymmetricUtil(root.left, root.right);
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);

		_101_Symmetric_Tree solution = new _101_Symmetric_Tree();

		System.out.print("Binary Tree (Inorder): ");
		printInorder(root);
		System.out.println();

		boolean res = solution.isSymmetric(root);

		if (res) {
			System.out.println("This Tree is Symmetrical");
		} else {
			System.out.println("This Tree is NOT Symmetrical");
		}

	}

	private static void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);

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
