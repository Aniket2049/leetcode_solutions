package tuf.arrays3;

// https://leetcode.com/problems/unique-paths/description/
// https://www.youtube.com/watch?v=t_f0nwwdg5o
// https://www.youtube.com/watch?v=IlEsdxuD4lY
public class _62_Unique_Paths {

	public int uniquePaths(int m, int n) {
		int N = m + n - 2;
		int r = m - 1;
		double res = 1;

		for (int i = 1; i <= r; i++) {
			res = res * (N - r + i) / i;
		}

		return (int) res;

	}

	public static void main(String[] args) {
//		Example 1:
//		Input: m = 3, n = 7
//		Output: 28
		System.out.println(new _62_Unique_Paths().uniquePaths(3, 7));

//		Example 2:
//		Input: m = 3, n = 2
//		Output: 3
//		Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//		1. Right -> Down -> Down
//		2. Down -> Down -> Right
//		3. Down -> Right -> Down
		System.out.println(new _62_Unique_Paths().uniquePaths(3, 2));


	}

}
