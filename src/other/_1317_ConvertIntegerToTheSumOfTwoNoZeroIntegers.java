package other;

// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

public class _1317_ConvertIntegerToTheSumOfTwoNoZeroIntegers {
	public int[] getNoZeroIntegers(int n) {
		for (int i = 1; i < n; i++) {
			int otherNum = n - i;

			if (!containsZero(otherNum) && !containsZero(i)) {
				return new int[] { i, otherNum };
			}
		}

		return new int[] {};
	}

	public boolean containsZero(int num) {
		while (num > 0) {
			if (num % 10 == 0)
				return true;
			num = num / 10;
		}
		return false;
	}
}
