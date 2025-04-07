package tuf_sde.string2;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/3249783/java-easy-with-explanation/
public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String {

	public int strStr(String haystack, String needle) {
		int haylength = haystack.length();
		int needlelength = needle.length();
		if (haylength < needlelength)
			return -1;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j))
				j++;
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: haystack = "sadbutsad", needle = "sad"
//		Output: 0
//		Explanation: "sad" occurs at index 0 and 6.
//		The first occurrence is at index 0, so we return 0.
		System.out.println(new _28_Find_the_Index_of_the_First_Occurrence_in_a_String().strStr("sadbutsad", "sad"));

//		Example 2:
//		Input: haystack = "leetcode", needle = "leeto"
//		Output: -1
//		Explanation: "leeto" did not occur in "leetcode", so we return -1.
		System.out.println(new _28_Find_the_Index_of_the_First_Occurrence_in_a_String().strStr("leetcode", "leeto"));

		System.out.println(new _28_Find_the_Index_of_the_First_Occurrence_in_a_String().strStr("aaa", "aaaa"));

		System.out
				.println(new _28_Find_the_Index_of_the_First_Occurrence_in_a_String().strStr("mississippi", "issipi"));

		System.out.println(new _28_Find_the_Index_of_the_First_Occurrence_in_a_String().strStr("sadbutsad", "sad"));

	}

}
