package neetcode.binarytree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// https://www.youtube.com/watch?v=gs2LMfuOR9k
public class _7_235_LowestCommonAncestorOfABinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode curr = root;

		while (curr != null) {
			if (p.val > curr.val && q.val > curr.val) {
				curr = curr.right;
			} else if (p.val < curr.val && q.val < curr.val) {
				curr = curr.left;
			} else {
				return curr;
			}
		}

		return root;
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
