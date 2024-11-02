package neetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements/description/
// https://www.youtube.com/watch?v=YPTqKIgVk-k
public class _347_Top_K_Frequent_Elements {

	public void printArr(int[] ans) {

		System.out.println();
		System.out.print("[");
		for (int i = 0; i < ans.length; i++) {
			if (i == ans.length - 1)
				System.out.print(ans[i]);
			else
				System.out.print(ans[i] + ",");
		}
		System.out.print("]");
	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> count = new HashMap<>();
		List<Integer> bucket[] = new ArrayList[nums.length + 1];

		for (int num : nums)
			count.put(num, count.getOrDefault(num, 0) + 1);

		for (int key : count.keySet()) {
			int freq = count.get(key);
			if (bucket[freq] == null)
				bucket[freq] = new ArrayList<>();
			bucket[freq].add(key);
		}

		int index = 0;
		int[] res = new int[k];
		for (int i = nums.length; i >= 0; i--)
			if (bucket[i] != null)
				for (int val : bucket[i]) {
					res[index++] = val;
					if (index == k) {
						printArr(res);
						return res;
					}
				}
		
		printArr(res);
		return res;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,1,1,2,2,3], k = 2
//		Output: [1,2]
		new _347_Top_K_Frequent_Elements().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
//		Example 2:
//		Input: nums = [1], k = 1
//		Output: [1]
		new _347_Top_K_Frequent_Elements().topKFrequent(new int[] { 1 }, 1);
//		Example 3:
//		Input: nums = [1,2], k = 2
//		Output: []
		new _347_Top_K_Frequent_Elements().topKFrequent(new int[] { 1, 2 }, 2);
//		Example 4:
//		Input: nums = [3,0,1,0], k = 1
//		Output: [0,1,3]
		new _347_Top_K_Frequent_Elements().topKFrequent(new int[] { 3, 0, 1, 0 }, 1);

	}

}
