package neetcode250.c_slidingwindow;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// https://www.youtube.com/watch?v=1pkOgXD63yU
public class _2_121_BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int l = 0;
		int r = 0;

		while (r < prices.length) {
			if (prices[l] < prices[r]) {
				int profit = prices[r] - prices[l];
				maxProfit = Math.max(maxProfit, profit);

			} else {
				l = r;
			}
			r++;
		}

		return maxProfit;
	}
}
