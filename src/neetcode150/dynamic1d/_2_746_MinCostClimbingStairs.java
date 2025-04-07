package neetcode150.dynamic1d;

// https://leetcode.com/problems/min-cost-climbing-stairs/
// https://www.youtube.com/watch?v=WeO_E5Q1kGw
public class _2_746_MinCostClimbingStairs {

	int minCostClimbingStairs(int[] cost) {

		int n = cost.length;
		int[] minCost = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			minCost[i] = Math.min((cost[i - 1] + minCost[i - 1]), (cost[i - 2] + minCost[i - 2]));
		}

		return minCost[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
