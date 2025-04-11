package neetcode250.a_arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// https://www.youtube.com/watch?v=3SJ3pUkPQMc
public class _19_122_BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += (prices[i] - prices[i - 1]);
			}
		}
		return profit;
	}
}
