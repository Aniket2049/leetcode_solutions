package tuf_sde.binarysearchtree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// https://www.youtube.com/watch?v=12omz-VAyRk
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;

		return constructTree(nums, 0, nums.length - 1);
	}

	private TreeNode constructTree(int[] nums, int left, int right) {
		if (left > right)
			return null;

		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = constructTree(nums, left, mid - 1);
		root.right = constructTree(nums, mid + 1, right);

		return root;
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
