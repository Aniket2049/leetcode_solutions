package neetcode150.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
// https://www.youtube.com/watch?v=rI2EBUEMfTk
public class _3_973_KClosestPointsToOrigin {

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
		for (int[] point : points) {
			int dist = point[0] * point[0] + point[1] * point[1];
			minHeap.offer(new int[] { dist, point[0], point[1] });
		}

		int[][] result = new int[k][2];
		for (int i = 0; i < k; ++i) {
			int[] point = minHeap.poll();
			result[i] = new int[] { point[1], point[2] };
		}
		return result;

	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 3 }, { -2, 2 } }; // [[-2,2]]
		int[][] ans = new _3_973_KClosestPointsToOrigin().kClosest(arr, 1);

		for (int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
	}

}
