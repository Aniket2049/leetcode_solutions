package tuf_sde.stack_queue2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

// https://leetcode.com/problems/lfu-cache/description/
// https://leetcode.com/problems/lfu-cache/solutions/3111521/o-1-time-full-explanation-hashtable-c-java-python3/
// https://www.youtube.com/watch?v=0PSB9y8ehbk
public class _460_LFU_Cache {

	public static void main(String[] args) {
//		Example 1:
//		Input
//		["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
//		[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//		Output
//		[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//		Explanation
//		// cnt(x) = the use counter for key x
//		// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
//		LFUCache lfu = new LFUCache(2);
//		lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//		lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//		lfu.get(1);      // return 1
//		                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//		lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//		                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//		lfu.get(2);      // return -1 (not found)
//		lfu.get(3);      // return 3
//		                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//		lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//		                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//		lfu.get(1);      // return -1 (not found)
//		lfu.get(3);      // return 3
//		                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//		lfu.get(4);      // return 4
//		                 // cache=[4,3], cnt(4)=2, cnt(3)=3

		LFUCache cache = new LFUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		cache.get(2);
		cache.get(3);
		cache.put(4, 4);
		cache.get(1);
		cache.get(3);
		cache.get(4);
	}

}

class LFUCache {
	private int capacity;
	private int minFreq = 0;
	private Map<Integer, Integer> keyToVal = new HashMap<>();
	private Map<Integer, Integer> keyToFreq = new HashMap<>();
	private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();

	public LFUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!keyToVal.containsKey(key))
			return -1;

		final int freq = keyToFreq.get(key);
		freqToLRUKeys.get(freq).remove(key);
		if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
			freqToLRUKeys.remove(freq);
			++minFreq;
		}

		// Increase key's freq by 1
		// Add this key to next freq's list
		putFreq(key, freq + 1);
		return keyToVal.get(key);
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;
		if (keyToVal.containsKey(key)) {
			keyToVal.put(key, value);
			get(key); // Update key's count
			return;
		}

		if (keyToVal.size() == capacity) {
			// Evict LRU key from the minFreq list
			final int keyToEvict = freqToLRUKeys.get(minFreq).iterator().next();
			freqToLRUKeys.get(minFreq).remove(keyToEvict);
			keyToVal.remove(keyToEvict);
		}

		minFreq = 1;
		putFreq(key, minFreq); // Add new key and freq
		keyToVal.put(key, value); // Add new key and value
	}

	private void putFreq(int key, int freq) {
		keyToFreq.put(key, freq);
		freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
		freqToLRUKeys.get(freq).add(key);
	}
}