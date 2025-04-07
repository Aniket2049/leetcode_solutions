package tuf_sde.binarysearchtree2;

import java.util.HashSet;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
// https://www.youtube.com/watch?v=xMvhRaFCw2M
public class _653_Two_Sum_IV_Input_is_a_BST {

	HashSet<Integer> daSet = new HashSet<Integer>();

	public boolean findTarget(TreeNode root, int k) {
		return dfsSearch(root, k);
	}

	private boolean dfsSearch(TreeNode root, int k) {
		if (root == null)
			return false;
		if (daSet.contains(k - root.val))
			return true;
		daSet.add(root.val);
		return dfsSearch(root.left, k) || dfsSearch(root.right, k);
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
