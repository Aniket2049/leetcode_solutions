package neetcode.twopointers;

// https://leetcode.com/problems/valid-palindrome/
// https://www.youtube.com/watch?v=jJXJ16kPFWg
public class _125_Valid_Palindrome {

	public boolean isPalindrome(String s) {
		if (s.equals(" "))
			return true;

		String alphaNumericStr = s.replaceAll("[^A-Za-z0-9]", "");
		alphaNumericStr = alphaNumericStr.toLowerCase();

		if (alphaNumericStr.equals(" ") || alphaNumericStr.equals(""))
			return true;

		int i = 0;
		int j = alphaNumericStr.length() - 1;

		while (i < j) {
			if (alphaNumericStr.charAt(i) != alphaNumericStr.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	public boolean isPalindrome2(String s) {
		StringBuilder newStr = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				newStr.append(Character.toLowerCase(c));
			}
		}
		return newStr.toString().equals(newStr.reverse().toString());
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "A man, a plan, a canal: Panama"
//		Output: true
//		Explanation: "amanaplanacanalpanama" is a palindrome.

		String s = "A man, a plan, a canal: Panama";
		System.out.println(new _125_Valid_Palindrome().isPalindrome2(s));

//		Example 2:
//		Input: s = "race a car"
//		Output: false
//		Explanation: "raceacar" is not a palindrome.

		s = "race a car";
		System.out.println(new _125_Valid_Palindrome().isPalindrome2(s));

//		Example 3:
//		Input: s = " "
//		Output: true
//		Explanation: s is an empty string "" after removing non-alphanumeric characters.
//		Since an empty string reads the same forward and backward, it is a palindrome.

		s = " ";
		System.out.println(new _125_Valid_Palindrome().isPalindrome2(s));

		s = ".";
		System.out.println(new _125_Valid_Palindrome().isPalindrome2(s));

		s = "aa";
		System.out.println(new _125_Valid_Palindrome().isPalindrome2(s));
	}

}
