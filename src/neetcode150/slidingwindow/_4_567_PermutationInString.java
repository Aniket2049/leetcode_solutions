package neetcode150.slidingwindow;

import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/description/
// https://www.youtube.com/watch?v=quSfR-uwkZU
// https://github.com/gahogg/Leetcode-Solutions/blob/main/Permutation%20in%20String%20-%20Leetcode%20567/Permutation%20in%20String%20-%20Leetcode%20567.java
// https://algo.monster/liteproblems/567
public class _4_567_PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();

		if (n1 > n2)
			return false;

		int[] s1Counts = new int[26];
		int[] s2Counts = new int[26];

		for (int i = 0; i < n1; i++) {
			s1Counts[s1.charAt(i) - 'a']++;
			s2Counts[s2.charAt(i) - 'a']++;
		}

		if (Arrays.equals(s1Counts, s2Counts))
			return true;

		for (int i = n1; i < n2; i++) {
			s2Counts[s2.charAt(i) - 'a']++;
			s2Counts[s2.charAt(i - n1) - 'a']--;
			if (Arrays.equals(s1Counts, s2Counts))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s1 = "ab", s2 = "eidbaooo"
//		Output: true
//		Explanation: s2 contains one permutation of s1 ("ba").
		System.out.println(new _4_567_PermutationInString().checkInclusion("ab", "eidbaooo"));

//		Example 2:
//		Input: s1 = "hello", s2 = "ooolleoooleh"
//		Output: false
		System.out.println(new _4_567_PermutationInString().checkInclusion("hello", "ooolleoooleh"));
	}

}
