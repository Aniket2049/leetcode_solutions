package neetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// https://www.youtube.com/watch?v=hTM3phVI6YQ
public class _2_104_MaximumDepthOfBinaryTree {

	// recursive dfs
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// bfs
	public int maxDepthBFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
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
	
	// iterative dfs
	/*public int maxDepthIterativeDFS(TreeNode root) {
	    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
	    stack.push(new Pair<>(root, 1));
	    int res = 0;
	
	    while (!stack.isEmpty()) {
	        Pair<TreeNode, Integer> current = stack.pop();
	        TreeNode node = current.getKey();
	        int depth = current.getValue();
	
	        if (node != null) {
	            res = Math.max(res, depth);
	            stack.push(new Pair<>(node.left, depth + 1));
	            stack.push(new Pair<>(node.right, depth + 1));
	        }
	    }
	    return res;
	}
	
	static class Pair {
		TreeNode root;
		int num;
	
		Pair(TreeNode root, int num) {
			this.root = root;
			this.num = num;
		}
	}
	*/
}
