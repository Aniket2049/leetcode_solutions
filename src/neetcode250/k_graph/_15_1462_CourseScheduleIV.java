package neetcode250.k_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/course-schedule-iv/
// https://www.youtube.com/watch?v=cEW05ofxhn0
public class _15_1462_CourseScheduleIV {
	private List<Integer>[] adj;
	private Map<Integer, Set<Integer>> prereqMap;

	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		adj = new ArrayList[numCourses];
		prereqMap = new HashMap<>();
		for (int i = 0; i < numCourses; i++)
			adj[i] = new ArrayList<>();
		for (int[] pre : prerequisites)
			adj[pre[1]].add(pre[0]);

		for (int crs = 0; crs < numCourses; crs++)
			dfs(crs);

		List<Boolean> res = new ArrayList<>();
		for (int[] query : queries) {
			res.add(prereqMap.get(query[1]).contains(query[0]));
		}
		return res;
	}

	private Set<Integer> dfs(int crs) {
		if (prereqMap.containsKey(crs))
			return prereqMap.get(crs);
		Set<Integer> prereqs = new HashSet<>();
		for (int pre : adj[crs]) {
			prereqs.addAll(dfs(pre));
		}
		prereqs.add(crs);
		prereqMap.put(crs, prereqs);
		return prereqs;
	}
}
