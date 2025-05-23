package neetcode250.b_twopointers;

// https://leetcode.com/problems/valid-palindrome-ii/
// https://www.youtube.com/watch?v=wX3-411uJH0
public class _3_680_ValidPalindromeII {
	boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			// Keep moving till characters match
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				// Try deleting 1 character from either direction
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
		}

		return true;
	}

	private boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else
				return false;
		}
		return true;
	}
}
