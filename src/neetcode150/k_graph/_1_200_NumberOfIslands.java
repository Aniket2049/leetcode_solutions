package neetcode150.k_graph;

// https://leetcode.com/problems/number-of-islands/
public class _1_200_NumberOfIslands {

	public static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
	}

	public int numIslands(char[][] grid) {
		if (grid == null)
			return 0;

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
