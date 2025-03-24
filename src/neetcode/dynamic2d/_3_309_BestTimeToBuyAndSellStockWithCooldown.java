package neetcode.dynamic2d;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
// https://www.youtube.com/watch?v=I7j0F7AHpb8
// https://www.youtube.com/watch?v=IGIe46xw3YY
public class _3_309_BestTimeToBuyAndSellStockWithCooldown {

	private Map<String, Integer> dp = new HashMap<>();

	public int maxProfit(int[] prices) {
		return dfs(0, true, prices);
	}

	private int dfs(int i, boolean buying, int[] prices) {
		if (i >= prices.length) {
			return 0;
		}

		String key = i + "-" + buying;
		if (dp.containsKey(key)) {
			return dp.get(key);
		}

		int cooldown = dfs(i + 1, buying, prices);
		if (buying) {
			int buy = dfs(i + 1, false, prices) - prices[i];
			dp.put(key, Math.max(buy, cooldown));
		} else {
			int sell = dfs(i + 2, true, prices) + prices[i];
			dp.put(key, Math.max(sell, cooldown));
		}

		return dp.get(key);
	}
}
