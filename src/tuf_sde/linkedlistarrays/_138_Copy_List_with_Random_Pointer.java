package tuf_sde.linkedlistarrays;

// https://leetcode.com/problems/copy-list-with-random-pointer/description/
// https://www.youtube.com/watch?v=q570bKdrnlw
public class _138_Copy_List_with_Random_Pointer {

	// Function to insert a copy of each
	// node in between the original nodes
	static void insertCopyInBetween(Node head) {
		Node temp = head;
		while (temp != null) {
			Node nextElement = temp.next;
			// Create a new node with the same data
			Node copy = new Node(temp.val);

			// Point the copy's next to
			// the original node's next
			copy.next = nextElement;

			// Point the original
			// node's next to the copy
			temp.next = copy;

			// Move to the next original node
			temp = nextElement;
		}
	}

	// Function to connect random
	// pointers of the copied nodes
	static void connectRandomPointers(Node head) {
		Node temp = head;
		while (temp != null) {
			// Access the copied node
			Node copyNode = temp.next;

			// If the original node
			// has a random pointer
			if (temp.random != null) {
				// Point the copied node's random to the
				// corresponding copied random node
				copyNode.random = temp.random.next;
			} else {
				// Set the copied node's random to
				// null if the original random is null
				copyNode.random = null;
			}

			// Move to the next original node
			temp = temp.next.next;
		}
	}

	// Function to retrieve the
	// deep copy of the linked list
	static Node getDeepCopyList(Node head) {
		Node temp = head;
		// Create a dummy node
		Node dummyNode = new Node(-1);
		// Initialize a result pointer
		Node res = dummyNode;

		while (temp != null) {
			// Creating a new List by
			// pointing to copied nodes
			res.next = temp.next;
			res = res.next;

			// Disconnect and revert back to the
			// initial state of the original linked list
			temp.next = temp.next.next;
			temp = temp.next;
		}

		// Return the deep copy of the
		// list starting from the dummy node
		return dummyNode.next;
	}

	public static Node copyRandomList(Node head) {
		// If the original list
		// is empty, return null
		if (head == null)
			return null;

		// Step 1: Insert copy of
		// nodes in between
		insertCopyInBetween(head);
		// Step 2: Connect random
		// pointers of copied nodes
		connectRandomPointers(head);
		// Step 3: Retrieve the deep
		// copy of the linked list
		return getDeepCopyList(head);
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print("Data: " + head.val);
			if (head.random != null) {
				System.out.print(", Random: " + head.random.val);
			} else {
				System.out.print(", Random: null");
			}
			System.out.println();
			// Move to the next node
			head = head.next;
		}
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//		Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

		// Example linked list: 7 -> 14 -> 21 -> 28
		Node head = new Node(7);
		head.next = new Node(14);
		head.next.next = new Node(21);
		head.next.next.next = new Node(28);

		// Assigning random pointers
		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next.next;
		head.next.next.next.random = head.next;

		System.out.println("Original Linked List with Random Pointers:");
		printLinkedList(head);

		// Clone the linked list
		Node clonedList = copyRandomList(head);

		System.out.println("\nCloned Linked List with Random Pointers:");
		printLinkedList(clonedList);

//		Example 2:
//		Input: head = [[1,1],[2,1]]
//		Output: [[1,1],[2,1]]

//		Example 3:
//		Input: head = [[3,null],[3,0],[3,null]]
//		Output: [[3,null],[3,0],[3,null]]

	}

}
