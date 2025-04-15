package neetcode250.c_slidingwindow;

import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://www.youtube.com/watch?v=U2ppEzBaMck
public class _3_3_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int l = 0;
		int r = 0;
		HashSet<Character> mySet = new HashSet<Character>();
		while (r < s.length()) {
			while (mySet.contains(s.charAt(r))) {
				mySet.remove(s.charAt(l));
				l++;
			}
			mySet.add(s.charAt(r));
			maxLength = Math.max(maxLength, r - l + 1);
			r++;
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s = "pwwkew";

		System.out.println(new _3_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
	}
}
