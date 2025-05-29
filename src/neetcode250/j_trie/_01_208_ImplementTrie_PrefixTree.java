package neetcode250.j_trie;

import java.util.HashMap;

// https://leetcode.com/problems/implement-trie-prefix-tree/
// https://www.youtube.com/watch?v=oobqoCJlHA0
public class _01_208_ImplementTrie_PrefixTree {
	public class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean endOfWord = false;
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				cur.children.putIfAbsent(c, new TrieNode());
				cur = cur.children.get(c);
			}
			cur.endOfWord = true;
		}

		public boolean search(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				if (!cur.children.containsKey(c)) {
					return false;
				}
				cur = cur.children.get(c);
			}
			return cur.endOfWord;
		}

		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (char c : prefix.toCharArray()) {
				if (!cur.children.containsKey(c)) {
					return false;
				}
				cur = cur.children.get(c);
			}
			return true;
		}
	}
}
