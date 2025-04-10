package tuf_sde.binarytree2;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
// https://www.youtube.com/watch?v=_-QHfMDde90
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// base case
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// result
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else { // both left and right are not null, we found our result
			return root;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}