package other;

// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
public class _2108_Find_First_Palindromic_String_in_the_Array {

	public boolean isPalindrome(String s) {
		StringBuilder newStr = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				newStr.append(Character.toLowerCase(c));
			}
		}
		return newStr.toString().equals(newStr.reverse().toString());
	}

	public String firstPalindrome(String[] words) {
		for (String word : words) {
			if (isPalindrome(word))
				return word;
		}
		return "";
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: words = ["abc","car","ada","racecar","cool"]
//		Output: "ada"
//		Explanation: The first string that is palindromic is "ada".
//		Note that "racecar" is also palindromic, but it is not the first.
		String[] words = { "abc", "car", "ada", "racecar", "cool" };
		System.out.println(new _2108_Find_First_Palindromic_String_in_the_Array().firstPalindrome(words));

//		Example 2:
//		Input: words = ["notapalindrome","racecar"]
//		Output: "racecar"
//		Explanation: The first and only string that is palindromic is "racecar".
		words = new String[] { "notapalindrome", "racecar" };
		System.out.println(new _2108_Find_First_Palindromic_String_in_the_Array().firstPalindrome(words));

//		Example 3:
//		Input: words = ["def","ghi"]
//		Output: ""
//		Explanation: There are no palindromic strings, so the empty string is returned.
		words = new String[] { "def", "ghi" };
		System.out.println(new _2108_Find_First_Palindromic_String_in_the_Array().firstPalindrome(words));

	}

}
