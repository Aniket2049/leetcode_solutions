package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
// https://www.youtube.com/watch?v=3jvWodd7ht0
public class _7_131_PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> part = new ArrayList<>();
		dfs(0, s, part, res);
		return res;
	}

	private void dfs(int i, String s, List<String> part, List<List<String>> res) {
		if (i >= s.length()) {
			res.add(new ArrayList<>(part));
			return;
		}
		for (int j = i; j < s.length(); j++) {
			if (isPali(s, i, j)) {
				part.add(s.substring(i, j + 1));
				dfs(j + 1, s, part, res);
				part.remove(part.size() - 1);
			}
		}
	}

	private boolean isPali(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> data = new _7_131_PalindromePartitioning().partition(s);

	}

}
