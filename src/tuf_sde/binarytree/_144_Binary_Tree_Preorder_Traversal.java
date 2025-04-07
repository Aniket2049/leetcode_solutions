package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// 
public class _144_Binary_Tree_Preorder_Traversal {

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

	public void preorderHelper(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		preorderHelper(root.left, list);
		preorderHelper(root.right, list);
		list.add(root.val);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<Integer>();
		preorderHelper(root, answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
