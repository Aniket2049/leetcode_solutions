package neetcode250.g_binarytree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/same-tree/
// https://www.youtube.com/watch?v=YPIaDOU4ZWc
// https://www.youtube.com/watch?v=vRbbcKXCxOw
public class _8_100_SameTree {
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

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

	public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.add(p);
		q2.add(q);

		while (!q1.isEmpty() && !q2.isEmpty()) {
			for (int i = q1.size(); i > 0; i--) {
				TreeNode nodeP = q1.poll();
				TreeNode nodeQ = q2.poll();

				if (nodeP == null && nodeQ == null)
					continue;
				if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val)
					return false;

				q1.add(nodeP.left);
				q1.add(nodeP.right);
				q2.add(nodeQ.left);
				q2.add(nodeQ.right);
			}
		}

		return true;
	}
}
