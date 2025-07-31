package other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/optimal-partition-of-string/
public class _2405_OptimalPartitionOfString {
	public int partitionString(String s) {
		ArrayList<String> res = new ArrayList<String>();
		Set<Character> currentChars = new HashSet<Character>();
		int startOfCurrentPart = 0;
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (currentChars.contains(currentChar)) {
				res.add(s.substring(startOfCurrentPart, i));
				currentChars.clear();
				startOfCurrentPart = i;
			}
			currentChars.add(s.charAt(i));
		}

		if (startOfCurrentPart < s.length()) {
			res.add(s.substring(startOfCurrentPart, s.length()));
		}

		return res.size();
	}

	public static boolean hasUniqueChars(String s) {
		Set<Character> mySet = new HashSet<Character>();
		for (char c : s.toCharArray()) {
			if (mySet.contains(c))
				return false;
			mySet.add(c);
		}
		return true;
	}
}
