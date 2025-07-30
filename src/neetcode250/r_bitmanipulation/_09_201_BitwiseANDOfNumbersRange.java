package neetcode250.r_bitmanipulation;

// https://leetcode.com/problems/bitwise-and-of-numbers-range/
// https://www.youtube.com/watch?v=3XYQLHSoew8
public class _09_201_BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int left, int right) {
		int shiftCount = 0;

		while (left != right) {
			left >>= 1;
			right >>= 1;
			shiftCount++;
		}

		return left << shiftCount;
	}
}
