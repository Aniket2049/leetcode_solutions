package neetcode150.l_graph2;

import java.util.Arrays;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
// https://algo.monster/liteproblems/787
// https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/4770625/only-10-simple-lines-all-language-solution/
public class _6_787_CheapestFlightsWithinKStops {

	// bellman ford
	// Represent an unreachable cost with a high value
	private static final int INFINITY = 0x3f3f3f3f;

	// Finds the cheapest price for a flight with up to k stops
	public int findCheapestPrice(int n, int[][] flights, int source, int destination, int k) {
		// Initialize distance array with infinity to represent no flights booked yet
		int[] currentDist = new int[n];
		// Backup array used during relaxation to avoid overwriting information prematurely
		int[] prevDist = new int[n];
		// Fill the distance array with infinity
		Arrays.fill(currentDist, INFINITY);
		// The cost to get to the source from the source is 0
		currentDist[source] = 0;

		// Perform relaxation k+1 times (since 0 stops means just 1 flight)
		for (int i = 0; i < k + 1; ++i) {
			// Copy current distances to the backup array
			System.arraycopy(currentDist, 0, prevDist, 0, n);
			// Iterate through each flight
			for (int[] flight : flights) {
				int from = flight[0], to = flight[1], cost = flight[2];
				// Relax the distance if a shorter path is found
				// Only update the distance using values from previous iteration (prevDist)
				currentDist[to] = Math.min(currentDist[to], prevDist[from] + cost);
			}
		}
		// If destination is reachable, return the cost, otherwise return -1
		return currentDist[destination] == INFINITY ? -1 : currentDist[destination];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
