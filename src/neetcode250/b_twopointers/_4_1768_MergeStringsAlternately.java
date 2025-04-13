package neetcode250.b_twopointers;

// https://leetcode.com/problems/merge-strings-alternately/
// https://www.youtube.com/watch?v=LECWOvTo-Sc
public class _4_1768_MergeStringsAlternately {
	public String mergeAlternately(String word1, String word2) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		int n1 = word1.length();
		int n2 = word2.length();
		boolean isFirst = true;

		while (i < n1 && j < n2) {
			if (isFirst) {
				sb.append(word1.charAt(i));
				i++;
				isFirst = false;
			} else {
				sb.append(word2.charAt(j));
				j++;
				isFirst = true;
			}
		}

		while (i < n1) {
			sb.append(word1.charAt(i));
			i++;
		}
		while (j < n2) {
			sb.append(word2.charAt(j));
			j++;
		}

		return sb.toString();
	}
}
