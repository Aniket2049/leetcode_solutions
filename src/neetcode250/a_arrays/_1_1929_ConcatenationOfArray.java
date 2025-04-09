package neetcode250.a_arrays;

// https://leetcode.com/problems/concatenation-of-array/
// https://www.youtube.com/watch?v=68isPRHgcFQ
public class _1_1929_ConcatenationOfArray {

	public int[] getConcatenation(int[] nums) {
		int n = nums.length;
		int[] res = new int[n * 2];
		for (int i = 0; i < n; i++) {
			res[i] = nums[i];
			res[i + n] = nums[i];
		}

		return res;
	}
}
