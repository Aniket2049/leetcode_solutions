package neetcode250.j_trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/extra-characters-in-a-string/
// https://www.youtube.com/watch?v=uQuSzPKtoVU
public class _03_2707_ExtraCharactersInAString {
	int[] t = new int[51];

	public int solve(int i, String s, Set<String> stack, int n) {
		if (i >= n) {
			return 0;
		}

		if (t[i] != -1) {
			return t[i];
		}

		int result = 1 + solve(i + 1, s, stack, n); // skipping the ith character

		for (int j = i; j < n; j++) {
			String curr = s.substring(i, j + 1);
			if (stack.contains(curr)) {
				// valid substring
				result = Math.min(result, solve(j + 1, s, stack, n));
			}
		}

		return t[i] = result;
	}

	public int minExtraChar(String s, String[] dict) {
		int n = s.length();
		Arrays.fill(t, -1);
		Set<String> stack = new HashSet<>();
		for (String str : dict)
			stack.add(str);

		return solve(0, s, stack, n);
	}

}
