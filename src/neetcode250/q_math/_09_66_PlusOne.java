package neetcode250.q_math;

// https://leetcode.com/problems/plus-one/
// https://www.youtube.com/watch?v=jIaA8boiG1s
public class _09_66_PlusOne {
	public int[] plusOne(int[] digits) {
		boolean carry = true;

		for (int j = digits.length - 1; j >= 0; j--) {
			if (carry) {
				if (digits[j] == 9) {
					digits[j] = 0;
				} else {
					digits[j]++;
					carry = false;
				}
			}
		}
		if (carry) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			System.arraycopy(digits, 0, result, 1, digits.length);
			return result;
		}
		return digits;
	}
}
