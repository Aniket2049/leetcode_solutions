package tuf_sde.string;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// https://www.youtube.com/watch?v=uX0-xyPkR2w
public class _5_Longest_Palindromic_Substring {

	public String longestPalindrome(String str) {
		if (str.length() <= 1)
			return str;

		String LPS = "";

		for (int i = 1; i < str.length(); i++) {

			// Consider odd length
			int low = i;
			int high = i;
			while (str.charAt(low) == str.charAt(high)) {
				low--;
				high++;

				if (low == -1 || high == str.length())
					break;
			}

			String palindrome = str.substring(low + 1, high);
			if (palindrome.length() > LPS.length()) {
				LPS = palindrome;
			}

			// Consider even length
			low = i - 1;
			high = i;
			while (str.charAt(low) == str.charAt(high)) {
				low--;
				high++;

				if (low == -1 || high == str.length())
					break;
			}

			palindrome = str.substring(low + 1, high);
			if (palindrome.length() > LPS.length()) {
				LPS = palindrome;
			}
		}

		return LPS;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "babad"
//		Output: "bab"
//		Explanation: "aba" is also a valid answer.
		System.out.println(new _5_Longest_Palindromic_Substring().longestPalindrome("babad"));
		
//		Example 2:
//		Input: s = "cbbd"
//		Output: "bb"
		System.out.println(new _5_Longest_Palindromic_Substring().longestPalindrome("cbbd"));
	}

}
