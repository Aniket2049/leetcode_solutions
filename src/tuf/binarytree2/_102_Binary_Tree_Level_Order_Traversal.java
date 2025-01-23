package tuf.binarytree2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _102_Binary_Tree_Level_Order_Traversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> answer = new ArrayList();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> currentLevel = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				currentLevel.add(node.val);
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
			answer.add(currentLevel);
		}
		return answer;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: root = [3,9,20,null,null,15,7]
//		Output: [[3],[9,20],[15,7]]
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);

		utility.Print.printIntListOfLists(new _102_Binary_Tree_Level_Order_Traversal().levelOrder(root1));
//		Example 2:
//		Input: root = [1]
//		Output: [[1]]
//		
//		Example 3:
//		Input: root = []
//		Output: []

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
