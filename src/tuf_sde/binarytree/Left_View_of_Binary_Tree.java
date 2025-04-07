package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
// https://www.youtube.com/watch?v=KV4mRzTjlAk
public class Left_View_of_Binary_Tree {

	public List<Integer> leftSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		leftView(root, result, 0);
		return result;
	}

	private void leftView(TreeNode root, List<Integer> result, int currentDepth) {
		if (root == null)
			return;

		if (currentDepth == result.size()) {
			result.add(root.val);
		}

		leftView(root.left, result, currentDepth + 1);
		leftView(root.right, result, currentDepth + 1);
	}

	public static void main(String[] args) {

	}

	public class TreeNode {
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
