package neetcode.math;

// https://leetcode.com/problems/plus-one/
// https://www.youtube.com/watch?v=tDjI08W1I7g
public class _5_66_PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
		int i = digits.length - 1;
		while (i >= 0) {
			int current = digits[i] + carry;
			digits[i] = current % 10;
			carry = current / 10;

			if (carry == 0)
				break;
			i--;
		}
		int[] newArr;
		if (carry == 1) {
			newArr = new int[digits.length + 1];
			newArr[0] = carry;
			int j = 0;
			while (j < digits.length) {
				newArr[j + 1] = digits[j];
				j++;
			}
			digits = newArr;
		}

		return digits;
	}

	public static void main(String[] args) {
		int[] res = new _5_66_PlusOne().plusOne(new int[] { 9 });
	}
}
