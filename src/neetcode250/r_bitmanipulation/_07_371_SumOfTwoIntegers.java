package neetcode250.r_bitmanipulation;

// https://leetcode.com/problems/sum-of-two-integers/
// https://www.youtube.com/watch?v=gVUrDV4tZfY
public class _07_371_SumOfTwoIntegers {
	public int getSum(int a, int b) {
		while (b != 0) {
			int carry = (a & b) << 1;
			a ^= b;
			b = carry;
		}
		return a;
	}
}
