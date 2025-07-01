package neetcode250.o_greedy;

// https://leetcode.com/problems/longest-turbulent-subarray/
// https://www.youtube.com/watch?v=V_iHUhR8Dek
public class _04_978_LongestTurbulentSubarray {
	public int maxTurbulenceSize(int[] arr) {
		int l = 0, r = 1, res = 1;
		String prev = "";

		while (r < arr.length) {
			if (arr[r - 1] > arr[r] && !">".equals(prev)) {
				res = Math.max(res, r - l + 1);
				r++;
				prev = ">";
			} else if (arr[r - 1] < arr[r] && !"<".equals(prev)) {
				res = Math.max(res, r - l + 1);
				r++;
				prev = "<";
			} else {
				r = (arr[r] == arr[r - 1]) ? r + 1 : r;
				l = r - 1;
				prev = "";
			}
		}

		return res;
	}
}
