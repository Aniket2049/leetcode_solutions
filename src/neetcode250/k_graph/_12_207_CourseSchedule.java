package neetcode250.k_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/course-schedule/
// https://www.youtube.com/watch?v=EgI5nU9etnU
public class _12_207_CourseSchedule {
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
}
