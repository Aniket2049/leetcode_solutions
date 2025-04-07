package tuf_sde.string;

// https://leetcode.com/problems/repeated-string-match/description/
// https://leetcode.com/problems/repeated-string-match/solutions/4632685/easy-and-simple-approach/
public class _686_Repeated_String_Match {

	public int repeatedStringMatch(String a, String b) {
		StringBuilder s = new StringBuilder(a);
		int count = 1;

		while (s.length() < b.length()) {
			s.append(a);
			count++;
		}

		if (s.indexOf(b) != -1) {
			return count;
		}

		s.append(a);
		count++;

		if (s.indexOf(b) != -1) {
			return count;
		}

		return -1;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: a = "abcd", b = "cdabcdab"
//		Output: 3
//		Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
		System.out.println(new _686_Repeated_String_Match().repeatedStringMatch("abcd", "cdabcdab"));

//		Example 2:
//		Input: a = "a", b = "aa"
//		Output: 2
		System.out.println(new _686_Repeated_String_Match().repeatedStringMatch("a", "aa"));
	}

}
