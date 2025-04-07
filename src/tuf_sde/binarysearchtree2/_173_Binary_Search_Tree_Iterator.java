package tuf_sde.binarysearchtree2;

import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-iterator/description/
// https://www.youtube.com/watch?v=D2jMcmxU4bs
public class _173_Binary_Search_Tree_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		pushAll(root);
	}

	public int next() {
		TreeNode temp = stack.pop();
		pushAll(temp.right);
		return temp.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void pushAll(TreeNode node) {
		for (; node != null; stack.push(node), node = node.left)
			;
	}

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
}