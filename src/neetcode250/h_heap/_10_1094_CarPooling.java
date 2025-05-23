package neetcode250.h_heap;

// https://leetcode.com/problems/car-pooling/
// https://www.youtube.com/watch?app=desktop&v=CUv2A9Q-k4s
public class _10_1094_CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
		int stops[] = new int[1001];
		for (int[] t : trips) {
			stops[t[1]] += t[0];
			stops[t[2]] -= t[0];
		}

		for (int i = 0; capacity >= 0 && i < 1001; ++i) {
			capacity -= stops[i];
		}
		return capacity >= 0;
	}
}
