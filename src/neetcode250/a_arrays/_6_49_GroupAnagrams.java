package neetcode250.a_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

// https://leetcode.com/problems/group-anagrams/
// https://www.youtube.com/watch?v=C9V66KyZCP8
public class _6_49_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();

		for (String s : strs) {
			char[] keyCharArray = s.toCharArray();
			Arrays.sort(keyCharArray);
			String key = String.valueOf(keyCharArray);

			if (!myMap.containsKey(key))
				myMap.put(key, new ArrayList<String>());

			myMap.get(key).add(s);
		}

		List<List<String>> res = new ArrayList<List<String>>();
		for (Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			res.add(myMap.get(entry.getKey()));
		}

		return res;
	}
}
