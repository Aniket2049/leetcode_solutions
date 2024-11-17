package tuf.arrays4;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
// 
public class _128_Longest_Consecutive_Sequence {

	public int longestConsecutive(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;

		int longest = 1;
		Set<Integer> set = new HashSet<>();

		// put all the array elements into set
		for (int i = 0; i < n; i++) {
			set.add(nums[i]);
		}

		// Find the longest sequence
		for (int it : set) {
			// if 'it' is a starting number
			if (!set.contains(it - 1)) {
				// find consecutive numbers
				int cnt = 1;
				int x = it;
				while (set.contains(x + 1)) {
					x = x + 1;
					cnt = cnt + 1;
				}
				longest = Math.max(longest, cnt);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [100,4,200,1,3,2]
//		Output: 4
//		Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
		System.out.println(
				new _128_Longest_Consecutive_Sequence().longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));

//		Example 2:
//		Input: nums = [0,3,7,2,5,8,4,6,0,1]
//		Output: 9
		System.out.println(
				new _128_Longest_Consecutive_Sequence().longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));

	}

}
