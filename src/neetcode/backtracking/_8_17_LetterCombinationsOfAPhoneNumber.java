package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// https://www.youtube.com/watch?v=0snEunUacZY
public class _8_17_LetterCombinationsOfAPhoneNumber {

	private List<String> res = new ArrayList<>();
	private String[] digitToChar = { "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty())
			return res;
		backtrack(0, "", digits);
		return res;
	}

	private void backtrack(int i, String curStr, String digits) {
		if (curStr.length() == digits.length()) {
			res.add(curStr);
			return;
		}
		String chars = digitToChar[digits.charAt(i) - '0'];
		for (char c : chars.toCharArray()) {
			backtrack(i + 1, curStr + c, digits);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
