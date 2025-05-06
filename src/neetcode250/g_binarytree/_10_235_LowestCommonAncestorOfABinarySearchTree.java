package neetcode250.g_binarytree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//
public class _10_235_LowestCommonAncestorOfABinarySearchTree {
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

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode cur = root;

		while (cur != null) {
			if (p.val > cur.val && q.val > cur.val) {
				cur = cur.right;
			} else if (p.val < cur.val && q.val < cur.val) {
				cur = cur.left;
			} else {
				return cur;
			}
		}
		return null;
	}
}
