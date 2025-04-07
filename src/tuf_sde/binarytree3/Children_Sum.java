package tuf_sde.binarytree3;

// https://www.geeksforgeeks.org/problems/children-sum-parent/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=hildren-sum-parent
// https://www.youtube.com/watch?v=fnmisPM6cVo
public class Children_Sum {

	// Function to change the values of the nodes
	// based on the sum of its children's values.
	public void changeTree(TreeNode root) {
		// Base case: If the current node
		// is null, return and do nothing.
		if (root == null) {
			return;
		}

		// Calculate the sum of the values of
		// the left and right children, if they exist.
		int child = 0;
		if (root.left != null) {
			child += root.left.val;
		}
		if (root.right != null) {
			child += root.right.val;
		}

		// Compare the sum of children with
		// the current node's value and update
		if (child >= root.val) {
			root.val = child;
		} else {
			// If the sum is smaller, update the
			// child with the current node's value.
			if (root.left != null) {
				root.left.val = root.val;
			} else if (root.right != null) {
				root.right.val = root.val;
			}
		}

		// Recursively call the function
		// on the left and right children.
		changeTree(root.left);
		changeTree(root.right);

		// Calculate the total sum of the
		// values of the left and right
		// children, if they exist.
		int tot = 0;
		if (root.left != null) {
			tot += root.left.val;
		}
		if (root.right != null) {
			tot += root.right.val;
		}

		// If either left or right child
		// exists, update the current node's
		// value with the total sum.
		if (root.left != null || root.right != null) {
			root.val = tot;
		}
	}

	public static void main(String[] args) {
		// Create the binary tree
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		Children_Sum sol = new Children_Sum();

		// Print the inorder traversal
		// of tree before modification
		System.out.print("Binary Tree before modification: ");
		TreeTraversal.inorderTraversal(root);
		System.out.println();

		// Call the changeTree function
		// to modify the binary tree
		sol.changeTree(root);

		// Print the inorder traversal
		// after modification
		System.out.print("Binary Tree after Children Sum Property: ");
		TreeTraversal.inorderTraversal(root);
		System.out.println();
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

//Function to print the inorder
//traversal of the tree
class TreeTraversal {
	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}
}
