package neetcode250.m_1Ddp;

// https://leetcode.com/problems/palindromic-substrings/
// https://www.youtube.com/watch?v=4RACzI5-du8
public class _07_647_PalindromicSubstrings {
	public int countSubstrings(String s) {
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			// odd length
			int l = i, r = i;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				res++;
				l--;
				r++;
			}

			// even length
			l = i;
			r = i + 1;
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				res++;
				l--;
				r++;
			}
		}

		return res;
	}
}
