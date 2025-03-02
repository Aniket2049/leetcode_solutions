package neetcode.slidingwindow;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
// https://www.youtube.com/watch?v=ExY8svHF_Eo
// https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/LongestRepeatingCharacterReplacement.java
public class _3_424LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int[] freq = new int[26];
		int left = 0;
		int maxFreq = 0;
		int maxWindow = 0;

		for (int right = 0; right < s.length(); right++) {

			// Update the frequency of the current character
			freq[s.charAt(right) - 'A']++;

			// Update the max frequency
			maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

			int windowLength = right - left + 1;

			// If the windowLength - max frequency > k,
			// then we need to shrink the window
			if (windowLength - maxFreq > k) {
				freq[s.charAt(left) - 'A']--;
				left++;
			}

			windowLength = right - left + 1;
			maxWindow = Math.max(maxWindow, windowLength);
		}

		return maxWindow;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "ABAB", k = 2
//		Output: 4
//		Explanation: Replace the two 'A's with two 'B's or vice versa.
		System.out.println(new _3_424LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
//		Example 2:
//		Input: s = "AABABBA", k = 1
//		Output: 4
//		Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//		The substring "BBBB" has the longest repeating letters, which is 4.
//		There may exists other ways to achieve this answer too.
		System.out.println(new _3_424LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
	}

}
