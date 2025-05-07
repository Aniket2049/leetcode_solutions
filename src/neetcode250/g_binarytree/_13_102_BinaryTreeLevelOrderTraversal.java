package neetcode250.g_binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
// https://www.youtube.com/watch?v=6ZnyEApgFYg
public class _13_102_BinaryTreeLevelOrderTraversal {
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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			List<Integer> level = new ArrayList<>();

			for (int i = q.size(); i > 0; i--) {
				TreeNode node = q.poll();
				if (node != null) {
					level.add(node.val);
					q.add(node.left);
					q.add(node.right);
				}
			}
			if (level.size() > 0) {
				res.add(level);
			}
		}
		return res;
	}

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> levelOrderDFS(TreeNode root) {
		dfs(root, 0);
		return res;
	}

	private void dfs(TreeNode node, int depth) {
		if (node == null) {
			return;
		}

		if (res.size() == depth) {
			res.add(new ArrayList<>());
		}

		res.get(depth).add(node.val);
		dfs(node.left, depth + 1);
		dfs(node.right, depth + 1);
	}
}
