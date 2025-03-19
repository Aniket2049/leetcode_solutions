package neetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/course-schedule/
// https://www.youtube.com/watch?v=EgI5nU9etnU
public class _8_207_CourseSchedule {

	// Map each course to its prerequisites
	private Map<Integer, List<Integer>> preMap = new HashMap<>();
	// Store all courses along the current DFS path
	private Set<Integer> visiting = new HashSet<>();

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		for (int i = 0; i < numCourses; i++) {
			preMap.put(i, new ArrayList<>());
		}
		for (int[] prereq : prerequisites) {
			preMap.get(prereq[0]).add(prereq[1]);
		}

		for (int c = 0; c < numCourses; c++) {
			if (!dfs(c)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int crs) {
		if (visiting.contains(crs)) {
			// Cycle detected
			return false;
		}
		if (preMap.get(crs).isEmpty()) {
			return true;
		}

		visiting.add(crs);
		for (int pre : preMap.get(crs)) {
			if (!dfs(pre)) {
				return false;
			}
		}
		visiting.remove(crs);
		preMap.put(crs, new ArrayList<>());
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canFinishTopologicalSort(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			indegree[pre[1]]++;
			adj.get(pre[0]).add(pre[1]);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int finish = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			finish++;
			for (int nei : adj.get(node)) {
				indegree[nei]--;
				if (indegree[nei] == 0) {
					q.add(nei);
				}
			}
		}

		return finish == numCourses;
	}

}
