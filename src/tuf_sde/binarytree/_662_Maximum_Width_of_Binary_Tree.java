package tuf_sde.binarytree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-width-of-binary-tree/description/
// https://www.youtube.com/watch?v=ZbybYvcVLks
// https://www.youtube.com/watch?v=hwjd0U36MUE
// https://leetcode.com/problems/maximum-width-of-binary-tree/solutions/6264338/bfs-easy-to-understand-full-explanation/
public class _662_Maximum_Width_of_Binary_Tree {

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 1));
		int first = 0, last = 0, res = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Pair curr = q.poll();
				int num = curr.num - 1;

				if (i == 0)
					first = num;
				if (i == size - 1)
					last = num;
				if (curr.root.left != null) {
					q.offer(new Pair(curr.root.left, 2 * num + 1));
				}
				if (curr.root.right != null) {
					q.offer(new Pair(curr.root.right, 2 * num + 2));
				}
			}
			res = Math.max(res, last - first + 1);
		}
		return res;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: root = [1,3,2,5,3,null,9]
//		Output: 4
//		Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

//		Example 2:
//		Input: root = [1,3,2,5,null,null,9,6,null,7]
//		Output: 7
//		Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

//		Example 3:
//		Input: root = [1,3,2,5]
//		Output: 2
//		Explanation: The maximum width exists in the second level with length 2 (3,2).

	}

	public class Pair {
		TreeNode root;
		int num;

		Pair(TreeNode root, int num) {
			this.root = root;
			this.num = num;
		}
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
