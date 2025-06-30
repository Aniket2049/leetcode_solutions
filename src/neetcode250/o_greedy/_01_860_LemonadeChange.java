package neetcode250.o_greedy;

// https://leetcode.com/problems/lemonade-change/
// https://www.youtube.com/watch?v=mSVAw0AUZgA
public class _01_860_LemonadeChange {
	public boolean lemonadeChange(int[] bills) {
		int five = 0, ten = 0;
		for (int b : bills) {
			if (b == 5) {
				five++;
			} else if (b == 10) {
				ten++;
				if (five > 0) {
					five--;
				} else {
					return false;
				}
			} else {
				if (five > 0 && ten > 0) {
					five--;
					ten--;
				} else if (five >= 3) {
					five -= 3;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
