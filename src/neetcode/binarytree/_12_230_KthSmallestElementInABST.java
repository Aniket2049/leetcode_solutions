package neetcode.binarytree;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class _12_230_KthSmallestElementInABST {

	public int kthSmallest(TreeNode root, int k) {
		int[] kSmallestValue = new int[] { Integer.MIN_VALUE };
		int[] traversalCounter = new int[] { 0 };
		inorder(root, traversalCounter, k, kSmallestValue);
		return kSmallestValue[0];
	}

	private void inorder(TreeNode node, int[] counter, int k, int[] kSmallest) {
		if (node == null || counter[0] >= k)
			return;

		inorder(node.left, counter, k, kSmallest);

		counter[0]++;

		if (counter[0] == k) {
			kSmallest[0] = node.val;
			return;
		}
		inorder(node.right, counter, k, kSmallest);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class TreeNode {
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
