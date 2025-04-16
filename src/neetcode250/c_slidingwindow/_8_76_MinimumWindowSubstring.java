package neetcode250.c_slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
// https://www.youtube.com/watch?v=jSto0O4AJbM
// https://www.youtube.com/watch?v=3Bp3OVD1EGc
public class _8_76_MinimumWindowSubstring {

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
		String s = "ADOBECODEBANC", t = "BANC";
		System.out.println(new _8_76_MinimumWindowSubstring().minWindow(s, t));
	}
}
