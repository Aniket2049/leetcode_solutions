package tuf.binarysearchtree;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
// https://www.youtube.com/watch?v=UmJT3j26t1I
public class _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
	}

	private TreeNode bstFromPreorder(int[] array, int bound, int[] i) {
		if (i[0] == array.length || array[i[0]] > bound)
			return null;

		TreeNode root = new TreeNode(array[i[0]++]);
		root.left = bstFromPreorder(array, root.val, i);
		root.right = bstFromPreorder(array, bound, i);

		return root;
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
