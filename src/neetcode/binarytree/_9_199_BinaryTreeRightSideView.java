package neetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/description/
// 
public class _9_199_BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int currentQSize = q.size();
			for (int i = 0; i < currentQSize; i++) {
				TreeNode current = q.poll();
				if (current != null && current.left != null)
					q.add(current.left);
				if (current != null && current.right != null)
					q.add(current.right);
				if (current != null && i == currentQSize - 1) {
					res.add(current.val);
				}
			}

		}

		return res;
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
