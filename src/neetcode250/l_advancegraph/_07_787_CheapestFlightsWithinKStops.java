package neetcode250.l_advancegraph;

import java.util.Arrays;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
// https://www.youtube.com/watch?v=5eIK3zUdYmE
public class _07_787_CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] prices = new int[n];
		Arrays.fill(prices, Integer.MAX_VALUE);
		prices[src] = 0;

		for (int i = 0; i <= k; i++) {
			int[] tmpPrices = Arrays.copyOf(prices, n);

			for (int[] flight : flights) {
				int s = flight[0];
				int d = flight[1];
				int p = flight[2];

				if (prices[s] == Integer.MAX_VALUE) {
					continue;
				}

				if (prices[s] + p < tmpPrices[d]) {
					tmpPrices[d] = prices[s] + p;
				}
			}

			prices = tmpPrices;
		}

		return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
	}
}
