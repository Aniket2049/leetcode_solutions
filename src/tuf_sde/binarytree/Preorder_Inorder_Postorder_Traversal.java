package tuf_sde.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/
// https://www.naukri.com/code360/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
// https://www.youtube.com/watch?v=ySp2epYvgTE
public class Preorder_Inorder_Postorder_Traversal {

	// Function to get the Preorder,
	// Inorder and Postorder traversal
	// Of Binary Tree in One traversal
	public static List<List<Integer>> preInPostTraversal(Node root) {
		// Lists to store traversals
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();

		// If the tree is empty,
		// return empty traversals
		if (root == null) {
			return new ArrayList<>();
		}

		// Stack to maintain nodes
		// and their traversal state
		Stack<Pair<Node, Integer>> st = new Stack<>();

		// Start with the root node
		// and state 1 (preorder)
		st.push(new Pair<>(root, 1));

		while (!st.empty()) {
			Pair<Node, Integer> it = st.pop();

			// this is part of pre
			if (it.getValue() == 1) {
				// Store the node's data
				// in the preorder traversal
				pre.add(it.getKey().data);
				// Move to state 2
				// (inorder) for this node
				it.setValue(2);
				// Push the updated state
				// back onto the stack
				st.push(it);

				// Push left child onto
				// the stack for processing
				if (it.getKey().left != null) {
					st.push(new Pair<>(it.getKey().left, 1));
				}
			}

			// this is a part of in
			else if (it.getValue() == 2) {
				// Store the node's data
				// in the inorder traversal
				in.add(it.getKey().data);
				// Move to state 3
				// (postorder) for this node
				it.setValue(3);
				// Push the updated state
				// back onto the stack
				st.push(it);

				// Push right child onto
				// the stack for processing
				if (it.getKey().right != null) {
					st.push(new Pair<>(it.getKey().right, 1));
				}
			}

			// this is part of post
			else {
				// Store the node's data
				// in the postorder traversal
				post.add(it.getKey().data);
			}
		}

		// Returning the traversals
		List<List<Integer>> result = new ArrayList<>();
		result.add(pre);
		result.add(in);
		result.add(post);
		return result;
	}

	// Function to print the
	// elements of a list
	public static void printList(List<Integer> list) {
		// Iterate through the list
		// and print each element
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		// Getting the pre-order, in-order,
		// and post-order traversals
		List<Integer> pre, in, post;
		List<List<Integer>> traversals = preInPostTraversal(root);

		// Extracting the traversals
		// from the result
		pre = traversals.get(0);
		in = traversals.get(1);
		post = traversals.get(2);

		// Printing the traversals
		System.out.print("Preorder traversal: ");
		printList(pre);

		System.out.print("Inorder traversal: ");
		printList(in);

		System.out.print("Postorder traversal: ");
		printList(post);

	}

	public static class Node {
		int data;
		Node left;
		Node right;

		Node() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Pair<T, U> {
		private T key;
		private U value;

		public Pair(T key, U value) {
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return this.key;
		}

		public U getValue() {
			return this.value;
		}

		public void setKey(T _key) {
			this.key = _key;
		}

		public void setValue(U _value) {
			this.value = _value;
		}
	}

}
