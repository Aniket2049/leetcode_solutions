package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
// https://www.youtube.com/watch?v=q_a6lpbKJdw
public class _987_Vertical_Order_Traversal_of_a_Binary_Tree {

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();
		Queue<Tuple> q = new LinkedList<Tuple>();
		q.offer(new Tuple(root, 0, 0));
		while (!q.isEmpty()) {
			Tuple tuple = q.poll();
			TreeNode node = tuple.node;
			int x = tuple.row;
			int y = tuple.col;

			if (!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
			}
			if (!map.get(x).containsKey(y)) {
				map.get(x).put(y, new PriorityQueue<>());
			}

			map.get(x).get(y).offer(node.val);

			if (node.left != null) {
				q.offer(new Tuple(node.left, x - 1, y + 1));
			}
			if (node.right != null) {
				q.offer(new Tuple(node.right, x + 1, y + 1));
			}
		}

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
			list.add(new ArrayList<Integer>());

			for (PriorityQueue<Integer> nodes : ys.values()) {
				while (!nodes.isEmpty()) {
//					System.out.println(nodes.peek());
					list.get(list.size() - 1).add(nodes.poll());
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: root = [3,9,20,null,null,15,7]
//		Output: [[9],[3,15],[20],[7]]
//		Explanation:
//		Column -1: Only node 9 is in this column.
//		Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
//		Column 1: Only node 20 is in this column.
//		Column 2: Only node 7 is in this column.

//		Example 2:
//		Input: root = [1,2,3,4,5,6,7]
//		Output: [[4],[2],[1,5,6],[3],[7]]
//		Explanation:
//		Column -2: Only node 4 is in this column.
//		Column -1: Only node 2 is in this column.
//		Column 0: Nodes 1, 5, and 6 are in this column.
//		          1 is at the top, so it comes first.
//		          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
//		Column 1: Only node 3 is in this column.
//		Column 2: Only node 7 is in this column.

		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(10);
		root.left.left.right = new TreeNode(5);
		root.left.left.right.right = new TreeNode(6);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(10);
		root.right.left = new TreeNode(9);

		_987_Vertical_Order_Traversal_of_a_Binary_Tree solution = new _987_Vertical_Order_Traversal_of_a_Binary_Tree();

		// Get the Vertical traversal
		List<List<Integer>> verticalTraversal = solution.verticalTraversal(root);

		// Print the result
		System.out.print("Vertical Traversal: ");
		printResult(verticalTraversal);
	}

	// Helper function to
	// print the result
	private static void printResult(List<List<Integer>> result) {
		for (List<Integer> level : result) {
			for (int node : level) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
		System.out.println();
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

	class Tuple {
		TreeNode node;
		int row;
		int col;

		public Tuple(TreeNode _node, int _row, int _col) {
			node = _node;
			row = _row;
			col = _col;
		}
	}

}
