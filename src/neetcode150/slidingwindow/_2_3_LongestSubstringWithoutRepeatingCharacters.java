package neetcode150.slidingwindow;

import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// https://www.youtube.com/watch?v=wiGpQwVHdE0
public class _2_3_LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		HashSet<Character> charSet = new HashSet<>();
		int l = 0;
		int res = 0;

		for (int r = 0; r < s.length(); r++) {
			while (charSet.contains(s.charAt(r))) {
				charSet.remove(s.charAt(l));
				l++;
			}
			charSet.add(s.charAt(r));
			res = Math.max(res, r - l + 1);
		}
		return res;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "abcabcbb"
//		Output: 3
//		Explanation: The answer is "abc", with the length of 3.
		System.out.println(new _2_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));

//		Example 2:
//		Input: s = "bbbbb"
//		Output: 1
//		Explanation: The answer is "b", with the length of 1.
		System.out.println(new _2_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));

//		Example 3:
//		Input: s = "pwwkew"
//		Output: 3
//		Explanation: The answer is "wke", with the length of 3.
//		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		System.out.println(new _2_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));

	}

}
