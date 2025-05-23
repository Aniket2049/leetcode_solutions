package tuf_sde.arrays4;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// https://www.youtube.com/watch?v=qtVh-XEpsJo
public class _3_Longest_Substring_Without_Repeating_Characters {

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();

		int left = 0, right = 0;
		int n = s.length();
		int len = 0;
		while (right < n) {
			if (mpp.containsKey(s.charAt(right)))
				left = Math.max(mpp.get(s.charAt(right)) + 1, left);

			mpp.put(s.charAt(right), right);

			len = Math.max(len, right - left + 1);
			right++;
		}
		return len;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "abcabcbb"
//		Output: 3
//		Explanation: The answer is "abc", with the length of 3.
		System.out
				.println(new _3_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("abcabcbb"));

//		Example 2:
//		Input: s = "bbbbb"
//		Output: 1
//		Explanation: The answer is "b", with the length of 1.
		System.out.println(new _3_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("bbbbb"));

//		Example 3:
//		Input: s = "pwwkew"
//		Output: 3
//		Explanation: The answer is "wke", with the length of 3.
//		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		System.out.println(new _3_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("pwwkew"));

	}

}
