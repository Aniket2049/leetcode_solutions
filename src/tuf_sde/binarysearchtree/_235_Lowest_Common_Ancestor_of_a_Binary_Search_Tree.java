package tuf_sde.binarysearchtree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// https://www.youtube.com/watch?v=cX_kPV_foZc
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		int currentVal = root.val;
		if (currentVal < p.val && currentVal < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		if (currentVal > p.val && currentVal > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
