package neetcode250.e_binarysearch;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// https://www.youtube.com/watch?v=f2qf4u_O2QE
public class _7_1011_CapacityToShipPackagesWithinDDays {
	public int shipWithinDays(int[] weights, int days) {
		int minCap = 0;
		int maxCap = 0;
		for (int weight : weights) {

			minCap = Math.max(minCap, weight);
			maxCap += weight;
		}

		// Apply binary search
		while (minCap < maxCap) {
			int mid = minCap + (maxCap - minCap) / 2;

			// Try to ship with "mid" capacity
			int daysToShip = 1;
			int sum = 0;
			for (int weight : weights) {
				if (sum + weight > mid) {
					daysToShip++;
					sum = 0;
				}
				sum += weight;
			}

			// If more days are required, increase capacity
			if (daysToShip > days)
				minCap = mid + 1;
			else
				maxCap = mid;
		}

		return minCap;
	}
}
