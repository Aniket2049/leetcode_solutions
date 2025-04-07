package neetcode150.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/course-schedule-ii/
// https://www.youtube.com/watch?v=Akt3glAwyfY
public class _9_210_CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> prereq = new HashMap<>();
		for (int[] pair : prerequisites) {
			prereq.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
		}

		List<Integer> output = new ArrayList<>();
		Set<Integer> visit = new HashSet<>();
		Set<Integer> cycle = new HashSet<>();

		for (int course = 0; course < numCourses; course++) {
			if (!dfs(course, prereq, visit, cycle, output)) {
				return new int[0];
			}
		}

		int[] result = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			result[i] = output.get(i);
		}
		return result;
	}

	private boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> visit, Set<Integer> cycle,
			List<Integer> output) {

		if (cycle.contains(course)) {
			return false;
		}
		if (visit.contains(course)) {
			return true;
		}

		cycle.add(course);
		for (int pre : prereq.getOrDefault(course, Collections.emptyList())) {
			if (!dfs(pre, prereq, visit, cycle, output)) {
				return false;
			}
		}
		cycle.remove(course);
		visit.add(course);
		output.add(course);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findOrderTopologicalSort(int numCourses, int[][] prerequisites) {
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
		int[] output = new int[numCourses];
		while (!q.isEmpty()) {
			int node = q.poll();
			output[numCourses - finish - 1] = node;
			finish++;
			for (int nei : adj.get(node)) {
				indegree[nei]--;
				if (indegree[nei] == 0) {
					q.add(nei);
				}
			}
		}

		if (finish != numCourses) {
			return new int[0];
		}
		return output;
	}

}
