package neetcode.binarytree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
// https://neetcode.io/solutions/binary-tree-level-order-traversal
public class _8_102_BinaryTreeLevelOrderTraversal {

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
