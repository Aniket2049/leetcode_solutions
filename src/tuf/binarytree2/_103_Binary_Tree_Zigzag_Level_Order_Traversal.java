package tuf.binarytree2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// https://www.youtube.com/watch?v=3OXWEdlIGl4
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/6327477/beats-100-users-java-easy-to-understand/
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/6326739/collections-reverse-with-flag/
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// Result list to store levels
		List<List<Integer>> ans = new ArrayList<>();

		// Handle empty tree case
		if (root == null)
			return ans;

		// Queue for BFS traversal
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		// Variable to toggle traversal direction
		boolean reverse = false;

		// Traverse levels
		while (!q.isEmpty()) {
			int size = q.size(); // Number of nodes in the current level
			List<Integer> ls = new ArrayList<>(); // List to store current level values

			// Process all nodes at the current level
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll(); // Remove node from queue
				ls.add(temp.val); // Add node value to the current level list

				// Add left and right children to the queue
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}

			// Reverse the current level if needed
			if (reverse) {
				Collections.reverse(ls);
			}

			// Add the current level list to the result
			ans.add(ls);

			// Toggle the reverse flag for the next level
			reverse = !reverse;
		}

		return ans;
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		// Get the zigzag level order traversal
		List<List<Integer>> result = new _103_Binary_Tree_Zigzag_Level_Order_Traversal().zigzagLevelOrder(root);

		// Print the result
		printResult(result);

	}

	static void printResult(List<List<Integer>> result) {
		for (List<Integer> row : result) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
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
