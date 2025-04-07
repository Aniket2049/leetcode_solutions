package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/description/
// https://www.youtube.com/watch?v=KV4mRzTjlAk
public class _199_Binary_Tree_Right_Side_View {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	private void rightView(TreeNode root, List<Integer> result, int currentDepth) {
		if (root == null)
			return;

		if (currentDepth == result.size()) {
			result.add(root.val);
		}

		rightView(root.right, result, currentDepth + 1);
		rightView(root.left, result, currentDepth + 1);
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
