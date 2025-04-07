package tuf_sde.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/description/
// https://www.youtube.com/watch?v=WBgsABoClE0
public class _131_Palindrome_Partitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> path = new ArrayList<>();
		partitionHelper(0, s, path, res);
		return res;
	}

	static void partitionHelper(int index, String s, List<String> path, List<List<String>> res) {
		if (index == s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = index; i < s.length(); ++i) {
			if (isPalindrome(s, index, i)) {
				path.add(s.substring(index, i + 1));
				partitionHelper(i + 1, s, path, res);
				path.remove(path.size() - 1);
			}
		}
	}

	static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "aab"
//		Output: [["a","a","b"],["aa","b"]]
		utility.Print.printStringListOfLists(new _131_Palindrome_Partitioning().partition("aab"));

//		Example 2:
//		Input: s = "a"
//		Output: [["a"]]
		utility.Print.printStringListOfLists(new _131_Palindrome_Partitioning().partition("a"));

	}

}
