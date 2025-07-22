package neetcode250.r_bitmanipulation;

// https://leetcode.com/problems/single-number/
// https://www.youtube.com/watch?v=qMPX1AOa83k
public class _01_136_SingleNumber {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}
}
