package neetcode150.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/word-ladder/
// https://www.youtube.com/watch?v=h9iTnkgv05E
// https://algo.monster/liteproblems/127
// https://neetcode.io/solutions/word-ladder
// https://www.youtube.com/watch?v=M9cVl4d0v04
public class _13_127_WordLadder {

	private Set<String> wordSet;

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// Initialize the word set with the given word list
		wordSet = new HashSet<>(wordList);
		// If the endWord is not in the wordList, return 0 as no ladder exists
		if (!wordSet.contains(endWord)) {
			return 0;
		}
		// Use two queues to implement bidirectional BFS
		Queue<String> queueBegin = new ArrayDeque<>();
		Queue<String> queueEnd = new ArrayDeque<>();
		// Maps to keep track of the path lengths from the begin and end words
		Map<String, Integer> visitedBegin = new HashMap<>();
		Map<String, Integer> visitedEnd = new HashMap<>();
		// Initialize the queues and maps
		queueBegin.offer(beginWord);
		queueEnd.offer(endWord);
		visitedBegin.put(beginWord, 1); // The step count starts at 1
		visitedEnd.put(endWord, 1);

		// Perform BFS until one of the queues is empty
		while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
			// Always extend the smaller queue in the current iteration
			int result = queueBegin.size() <= queueEnd.size() ? extendQueue(visitedBegin, visitedEnd, queueBegin)
					: extendQueue(visitedEnd, visitedBegin, queueEnd);
			// If a connection is found, return the total length of the path
			if (result != -1) {
				return result;
			}
		}
		// If no path is found, return 0
		return 0;
	}

	private int extendQueue(Map<String, Integer> visitedOne, Map<String, Integer> visitedOther, Queue<String> queue) {
		// Process each word in the current layer
		for (int i = queue.size(); i > 0; --i) {
			String currentWord = queue.poll();
			int currentStep = visitedOne.get(currentWord);
			char[] characters = currentWord.toCharArray();
			// Try changing every character to make new words
			for (int j = 0; j < characters.length; ++j) {
				char originalChar = characters[j];
				for (char ch = 'a'; ch <= 'z'; ++ch) {
					characters[j] = ch;
					String newWord = new String(characters);
					// Skip if the new word is not in the word set or already visited
					if (!wordSet.contains(newWord) || visitedOne.containsKey(newWord)) {
						continue;
					}
					// If the new word is in the other visited map, a path is found
					if (visitedOther.containsKey(newWord)) {
						return currentStep + visitedOther.get(newWord);
					}
					// Otherwise, add the new word to the queue and visited map
					queue.offer(newWord);
					visitedOne.put(newWord, currentStep + 1);
				}
				// Restore the original character
				characters[j] = originalChar;
			}
		}
		// If no progress is made in this direction, return -1
		return -1;
	}

	
    public int ladderLengthSimpleBFS(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        while (!q.isEmpty()) {
            res++;
            for (int i = q.size(); i > 0; i--) {
                String node = q.poll();
                if (node.equals(endWord)) return res;
                for (int j = 0; j < node.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == node.charAt(j)) continue;
                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        if (words.contains(nei)) {
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
