package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://takeuforward.org/data-structure/top-view-of-a-binary-tree/
// https://www.youtube.com/watch?v=Et9OCDNvJ78
public class Top_View_of_Binary_Tree {

	public List<Integer> topView(Node root) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		if (root == null)
			return answer;

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Queue<Node> q = new LinkedList<Top_View_of_Binary_Tree.Node>();
		root.verticalOffset = 0;
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.verticalOffset;
			if (!map.containsKey(hd))
				map.put(hd, temp.data);
			if (temp.left != null) {
				temp.left.verticalOffset = hd - 1;
				q.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.verticalOffset = hd + 1;
				q.add(temp.right);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			answer.add(entry.getValue());
		}

		return answer;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(10);
		root.left.left.right = new Node(5);
		root.left.left.right.right = new Node(6);
		root.right = new Node(3);
		root.right.right = new Node(10);
		root.right.left = new Node(9);

		// Get the Top View traversal
		List<Integer> topView = new Top_View_of_Binary_Tree().topView(root);

		// Print the result
		System.out.println("Top View Traversal: ");
		for (int node : topView) {
			System.out.print(node + " ");
		}

	}

	public static class Node {
		int data;
		Node left;
		Node right;
		int verticalOffset;

		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

}
