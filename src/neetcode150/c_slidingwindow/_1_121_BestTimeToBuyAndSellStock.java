package neetcode150.c_slidingwindow;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// https://www.youtube.com/watch?v=1pkOgXD63yU
public class _1_121_BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int l = 0, r = 1;
		int maxP = 0;

		while (r < prices.length) {
			if (prices[l] < prices[r]) {
				int profit = prices[r] - prices[l];
				maxP = Math.max(maxP, profit);
			} else {
				l = r;
			}
			r++;
		}
		return maxP;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		//5
		System.out.println(new _1_121_BestTimeToBuyAndSellStock().maxProfit(prices));

		prices = new int[] { 7, 6, 4, 3, 1 };
		//0
		System.out.println(new _1_121_BestTimeToBuyAndSellStock().maxProfit(prices));

		prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
		//4
		System.out.println(new _1_121_BestTimeToBuyAndSellStock().maxProfit(prices));

	}

}
