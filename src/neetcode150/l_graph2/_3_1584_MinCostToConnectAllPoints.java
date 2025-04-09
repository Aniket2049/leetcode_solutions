package neetcode150.l_graph2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/min-cost-to-connect-all-points/
// https://www.youtube.com/watch?v=f7JOBJIC-NA
// https://www.youtube.com/watch?v=8VPIrqwQ8sQ
public class _3_1584_MinCostToConnectAllPoints {

	// prims
	public int minCostConnectPoints(int[][] points) {
		int N = points.length;
		Map<Integer, List<int[]>> adj = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			for (int j = i + 1; j < N; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];
				int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
				adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] { dist, j });
				adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] { dist, i });
			}
		}

		// prims
		int res = 0;
		Set<Integer> visit = new HashSet<>();
		PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		minH.offer(new int[] { 0, 0 });
		while (visit.size() < N) {
			int[] curr = minH.poll();
			int cost = curr[0];
			int i = curr[1];
			if (visit.contains(i)) {
				continue;
			}
			res += cost;
			visit.add(i);
			for (int[] nei : adj.getOrDefault(i, Collections.emptyList())) {
				int neiCost = nei[0];
				int neiIndex = nei[1];
				if (!visit.contains(neiIndex)) {
					minH.offer(new int[] { neiCost, neiIndex });
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
