package neetcode250.g_binarytree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// https://www.youtube.com/watch?v=o2LEC2NEVuk
public class _5_104_MaximumDepthOfBinaryTree {
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

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int lH = maxDepth(root.left);
		int rH = maxDepth(root.right);

		return 1 + Math.max(lH, rH);
	}

	public int maxDepthBFS(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		if (root != null) {
			q.add(root);
		}

		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			level++;
		}
		return level;
	}
}
