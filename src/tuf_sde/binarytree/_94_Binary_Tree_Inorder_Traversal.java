package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// Morris Inorder Traversal - https://www.youtube.com/watch?v=Wq3ibaP4dJY
public class _94_Binary_Tree_Inorder_Traversal {

	List<Integer> answer;

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

	public void inorderHelper(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorderHelper(root.left, list);
		list.add(root.val);
		inorderHelper(root.right, list);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<Integer>();
		inorderHelper(root, answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> inorderMorrisTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<Integer>();
		TreeNode current = root;

		while (current != null) {
			if (current.left == null) {
				answer.add(current.val);
				current = current.right;
			} else {
				TreeNode leftChild = current.left;
				while (leftChild.right != null) {
					leftChild = leftChild.right;
				}

				leftChild.right = current;
				TreeNode temp = current;
				current = current.left;
				temp.left = null;
			}
		}

		return answer;
	}

}
