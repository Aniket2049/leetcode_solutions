package neetcode250.c_slidingwindow;

// https://leetcode.com/problems/longest-repeating-character-replacement/
// https://www.youtube.com/watch?v=ExY8svHF_Eo
public class _4_424_LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int[] freq = new int[26];
		int left = 0;
		int maxFreq = 0;
		int maxWindow = 0;

		for (int right = 0; right < s.length(); right++) {
			freq[s.charAt(right) - 'A']++;
			maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
			int currentWindowSize = right - left + 1;

			if (currentWindowSize - maxFreq > k) {
				freq[s.charAt(left) - 'A']--;
				left++;
			}

			currentWindowSize = right - left + 1;
			maxWindow = Math.max(maxWindow, currentWindowSize);
		}
		return maxWindow;
	}
}
