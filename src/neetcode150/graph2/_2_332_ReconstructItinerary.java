package neetcode150.graph2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reconstruct-itinerary/
// https://algo.monster/liteproblems/332
// https://www.youtube.com/watch?v=5G0HyBhqpQo
public class _2_332_ReconstructItinerary {

	// Performs Depth-First Search recursively on the graph.
	private void dfs(Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary, String currentNode) {
		// Retrieve the neighbors (destinations) for the current node
		PriorityQueue<String> neighbors = graph.get(currentNode);

		// Process all neighbors
		while (neighbors != null && !neighbors.isEmpty()) {
			// Remove the top neighbor (next destination) from the queue and perform dfs
			String nextNode = neighbors.poll();
			dfs(graph, itinerary, nextNode);
		}

		// All flights from the current node have been used; add to the itinerary
		itinerary.addFirst(currentNode);
	}

	public List<String> findItinerary(List<List<String>> tickets) {
		// Create a graph from the list of tickets. Each node maps to a priority queue of destinations
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);  // Source airport
			String dest = ticket.get(1); // Destination airport

			// Initialize the priority queue if it does not already exist
			graph.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dest);
		}

		// This linked list will store the itinerary in reverse order
		LinkedList<String> itinerary = new LinkedList<>();

		// Start DFS from the "JFK" node
		dfs(graph, itinerary, "JFK");

		// The LinkedList itinerary already contains the nodes in reverse due to the use of addFirst().
		// Therefore, there's no need to reverse the itinerary at the end.
		return itinerary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
