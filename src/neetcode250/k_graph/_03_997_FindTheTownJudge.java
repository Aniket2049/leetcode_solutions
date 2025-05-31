package neetcode250.k_graph;

// https://leetcode.com/problems/find-the-town-judge/
// https://www.youtube.com/watch?v=QiGaxdUINJ8
public class _03_997_FindTheTownJudge {
	public int findJudge(int n, int[][] trust) {
		int[] incoming = new int[n + 1];
		int[] outgoing = new int[n + 1];

		for (int[] t : trust) {
			outgoing[t[0]]++;
			incoming[t[1]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (outgoing[i] == 0 && incoming[i] == n - 1) {
				return i;
			}
		}

		return -1;
	}
}
