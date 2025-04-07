package tuf_sde.string;

// https://leetcode.com/problems/reverse-words-in-a-string/description/
// https://www.youtube.com/watch?v=tX-ZcKTNwYk
public class _151_Reverse_Words_in_a_String {

	public String reverseWords(String s) {
		String[] words = s.split(" +");
		StringBuilder sb = new StringBuilder();

		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]);
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "the sky is blue"
//		Output: "blue is sky the"
		System.out.println(new _151_Reverse_Words_in_a_String().reverseWords("the sky is blue"));

//		Example 2:
//		Input: s = "  hello world  "
//		Output: "world hello"
//		Explanation: Your reversed string should not contain leading or trailing spaces.
		System.out.println(new _151_Reverse_Words_in_a_String().reverseWords("  hello world  "));

//		Example 3:
//		Input: s = "a good   example"
//		Output: "example good a"
//		Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
		System.out.println(new _151_Reverse_Words_in_a_String().reverseWords("a good   example"));

	}

}
