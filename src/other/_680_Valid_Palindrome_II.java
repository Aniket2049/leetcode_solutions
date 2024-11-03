package other;

// https://leetcode.com/problems/valid-palindrome-ii/description/
public class _680_Valid_Palindrome_II {

	public boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i <= j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
		}
		return true;
	}

	public boolean isPalindrome(String s, int i, int j) {
		while (i <= j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "aba"
//		Output: true
		String s = "aba";
		System.out.println(new _680_Valid_Palindrome_II().validPalindrome(s));

//		Example 2:
//		Input: s = "abca"
//		Output: true
//		Explanation: You could delete the character 'c'.
		s = "abca";
		System.out.println(new _680_Valid_Palindrome_II().validPalindrome(s));

//		Example 3:
//		Input: s = "abc"
//		Output: false
		s = "abc";
		System.out.println(new _680_Valid_Palindrome_II().validPalindrome(s));

	}

}
