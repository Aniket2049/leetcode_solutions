package neetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/description/
// https://www.youtube.com/watch?v=vzdNOK2oB2E
public class _49_Group_Anagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (String word : strs) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sortedWord = new String(chars);

			if (!map.containsKey(sortedWord)) {
				map.put(sortedWord, new ArrayList<String>());
			}

			map.get(sortedWord).add(word);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
//		Input: strs = ["eat","tea","tan","ate","nat","bat"]
//		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		_49_Group_Anagrams obj = new _49_Group_Anagrams();
		utility.Print.printStringListOfLists(obj.groupAnagrams(input));
	}

}
