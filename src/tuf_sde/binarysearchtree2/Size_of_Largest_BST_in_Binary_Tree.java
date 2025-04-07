package tuf_sde.binarysearchtree2;

// https://www.naukri.com/code360/problems/largest-bst-subtree_893103
// https://www.youtube.com/watch?v=X0oXMdtUDwo
public class Size_of_Largest_BST_in_Binary_Tree {

	public static int largestBST(TreeNode root) {
		return largestBST(root);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class NodeValue {
		public int maxNode, minNode, maxSize;

		public NodeValue(int maxNode, int minNode, int maxSize) {
			this.maxNode = maxNode;
			this.minNode = minNode;
			this.maxSize = maxSize;
		}
	}

	private NodeValue largestBSTSubtreeHelper(TreeNode root) {
		if (root == null) {
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		NodeValue left = largestBSTSubtreeHelper(root.left);
		NodeValue right = largestBSTSubtreeHelper(root.right);

		if (left.maxNode < root.data && root.data < right.minNode) {
			return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
					left.maxSize + right.maxSize + 1);

		}

		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
	}

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	};

}
