package neetcode.dynamic1d;

// https://leetcode.com/problems/longest-palindromic-substring/
// https://www.youtube.com/watch?v=uX0-xyPkR2w
// https://www.youtube.com/watch?v=XYQecbcd6_c
public class _5_5_LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int resultLength = 0, resultIndex = 0;

		for (int i = 0; i < s.length(); i++) {
			// odd length
			int l = i, r = i;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if (r - l + 1 > resultLength) {
					resultIndex = l;
					resultLength = r - l + 1;
				}
				l--;
				r++;
			}

			// even length
			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				if (r - l + 1 > resultLength) {
					resultIndex = l;
					resultLength = r - l + 1;
				}
				l--;
				r++;
			}
		}

		return s.substring(resultIndex, resultIndex + resultLength);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
