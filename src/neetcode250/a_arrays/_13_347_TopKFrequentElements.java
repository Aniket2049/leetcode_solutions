package neetcode250.a_arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements/
// https://www.youtube.com/watch?v=EBNPu0GgM64
public class _13_347_TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> topK = new ArrayList<>();
		for (int pos = bucket.length - 1; pos >= 0 && topK.size() < k; pos--) {
			if (bucket[pos] != null) {
				topK.addAll(bucket[pos]);
			}
		}

		return topK.stream().mapToInt(i -> i).toArray();
	}
}
