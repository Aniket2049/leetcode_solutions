package tuf_sde.string;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix/description/
// https://www.youtube.com/watch?v=wtOQaovlvhY
public class _14_Longest_Common_Prefix {

	public String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder();

		// Sort the array
		Arrays.sort(strs);

		// Get the first and last strings
		char[] first = strs[0].toCharArray();
		char[] last = strs[strs.length - 1].toCharArray();

		// Start comparing
		for (int i = 0; i < first.length; i++) {
			if (first[i] != last[i])
				break;
			result.append(first[i]);
		}

		return result.toString();
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: strs = ["flower","flow","flight"]
//		Output: "fl"
		System.out.println(
				new _14_Longest_Common_Prefix().longestCommonPrefix(new String[] { "flower", "flow", "flight" }));

//		Example 2:
//		Input: strs = ["dog","racecar","car"]
//		Output: ""
//		Explanation: There is no common prefix among the input strings.
		System.out
				.println(new _14_Longest_Common_Prefix().longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
	}

}
