package neetcode250.k_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/word-ladder/
// https://www.youtube.com/watch?v=h9iTnkgv05E
public class _21_127_WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}

		Map<String, List<String>> nei = new HashMap<>();
		wordList.add(beginWord);
		for (String word : wordList) {
			for (int j = 0; j < word.length(); j++) {
				String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
				nei.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
			}
		}

		Set<String> visit = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		int res = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				if (word.equals(endWord)) {
					return res;
				}
				for (int j = 0; j < word.length(); j++) {
					String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
					for (String neiWord : nei.getOrDefault(pattern, Collections.emptyList())) {
						if (!visit.contains(neiWord)) {
							visit.add(neiWord);
							q.offer(neiWord);
						}
					}
				}
			}
			res++;
		}
		return 0;
	}
}
