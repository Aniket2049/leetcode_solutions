package neetcode250.q_math;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/
// https://www.youtube.com/watch?v=3jdxYj3DD98
public class _10_13_RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> roman = new HashMap<>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);

		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
				res -= roman.get(s.charAt(i));
			} else {
				res += roman.get(s.charAt(i));
			}
		}
		return res;
	}
}
