package neetcode250.k_graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/graph-valid-tree/
// https://www.lintcode.com/problem/178/
// https://www.youtube.com/watch?v=bXsUuownnoQ
public class _14_261_GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		if (edges.length > n - 1) {
			return false;
		}

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		Set<Integer> visit = new HashSet<>();
		if (!dfs(0, -1, visit, adj)) {
			return false;
		}

		return visit.size() == n;
	}

	private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj) {
		if (visit.contains(node)) {
			return false;
		}

		visit.add(node);
		for (int nei : adj.get(node)) {
			if (nei == parent) {
				continue;
			}
			if (!dfs(nei, node, visit, adj)) {
				return false;
			}
		}
		return true;
	}
}
