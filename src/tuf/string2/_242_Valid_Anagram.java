package tuf.string2;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/description/
// 
public class _242_Valid_Anagram {

	public boolean isAnagram(String s, String t) {
		char[] sCharArr = s.toCharArray();
		char[] tCharArr = t.toCharArray();

		if (sCharArr.length != tCharArr.length)
			return false;

		Arrays.sort(sCharArr);
		Arrays.sort(tCharArr);

		for (int i = 0; i < sCharArr.length; i++) {
			if (sCharArr[i] != tCharArr[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: s = "anagram", t = "nagaram"
//		Output: true
		System.out.println(new _242_Valid_Anagram().isAnagram("anagram", "nagaram"));
		
//		Example 2:
//		Input: s = "rat", t = "car"
//		Output: false
		System.out.println(new _242_Valid_Anagram().isAnagram("rat", "car"));
	}

}
