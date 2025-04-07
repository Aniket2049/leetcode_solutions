package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
// 
public class _145_Binary_Tree_Postorder_Traversal {

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

	public void postorderHelper(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		postorderHelper(root.left, list);
		postorderHelper(root.right, list);
		list.add(root.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<Integer>();
		postorderHelper(root, answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
