package neetcode250.b_twopointers;

// https://leetcode.com/problems/reverse-string/
// https://www.youtube.com/watch?v=_d0T_2Lk2qA
public class _1_344_ReverseString {
	public void reverseString(char[] s) {
		int l = 0, r = s.length - 1;
		while (l < r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++;
			r--;
		}
	}
}
