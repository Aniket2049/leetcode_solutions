package neetcode150.c_slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
// https://www.youtube.com/watch?v=jSto0O4AJbM
// https://algo.monster/liteproblems/76
public class _5_76_MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		if (t.isEmpty())
			return "";

		Map<Character, Integer> countT = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();
		for (char c : t.toCharArray()) {
			countT.put(c, countT.getOrDefault(c, 0) + 1);
		}

		int have = 0, need = countT.size();
		int[] res = { -1, -1 };
		int resLen = Integer.MAX_VALUE;
		int l = 0;

		for (int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			window.put(c, window.getOrDefault(c, 0) + 1);

			if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
				have++;
			}

			while (have == need) {
				if ((r - l + 1) < resLen) {
					resLen = r - l + 1;
					res[0] = l;
					res[1] = r;
				}

				char leftChar = s.charAt(l);
				window.put(leftChar, window.get(leftChar) - 1);
				if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
					have--;
				}
				l++;
			}
		}

		return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "ADOBECODEBANC", t = "ABC"
//		Output: "BANC"
//		Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
		System.out.println(new _5_76_MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));

//		Example 2:
//		Input: s = "a", t = "a"
//		Output: "a"
//		Explanation: The entire string s is the minimum window.
		System.out.println(new _5_76_MinimumWindowSubstring().minWindow("a", "a"));

//		Example 3:
//		Input: s = "a", t = "aa"
//		Output: ""
//		Explanation: Both 'a's from t must be included in the window.
//		Since the largest window of s only has one 'a', return empty string.
		System.out.println(new _5_76_MinimumWindowSubstring().minWindow("a", "aa"));
	}

}
