package tuf.arrays1;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// https://www.youtube.com/watch?v=1pkOgXD63yU
public class _121_Best_Time_to_Buy_and_Sell_Stock {

	public int maxProfit(int[] prices) {
		int left = 0;
		int right = 1;
		int maxProfit = 0;

		while (right < prices.length) {
			if (prices[left] < prices[right]) {
				int profit = prices[right] - prices[left];
				maxProfit = Math.max(maxProfit, profit);
			} else {
				left = right;
			}

			right++;
		}

		return maxProfit;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: prices = [7,1,5,3,6,4]
//		Output: 5
//		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//		Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
		System.out.println(new _121_Best_Time_to_Buy_and_Sell_Stock().maxProfit(new int[] {7,1,5,3,6,4}));
//		Example 2:
//		Input: prices = [7,6,4,3,1]
//		Output: 0
//		Explanation: In this case, no transactions are done and the max profit = 0.
		System.out.println(new _121_Best_Time_to_Buy_and_Sell_Stock().maxProfit(new int[] {7,6,4,3,1}));

	}

}
