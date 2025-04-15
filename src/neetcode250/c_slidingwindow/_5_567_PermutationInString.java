package neetcode250.c_slidingwindow;

import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/
// https://www.youtube.com/watch?v=quSfR-uwkZU
public class _5_567_PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();

		if (n1 > n2)
			return false;

		int[] s1Freq = new int[26];
		int[] s2Freq = new int[26];

		for (int i = 0; i < n1; i++) {
			s1Freq[s1.charAt(i) - 'a']++;
			s2Freq[s2.charAt(i) - 'a']++;
		}

		if (Arrays.equals(s1Freq, s2Freq))
			return true;

		for (int i = n1; i < n2; i++) {
			s2Freq[s2.charAt(i) - 'a']++;
			s2Freq[s2.charAt(i - n1) - 'a']--;
			if (Arrays.equals(s1Freq, s2Freq))
				return true;
		}

		return false;
	}
}
