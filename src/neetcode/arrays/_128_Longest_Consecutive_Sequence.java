package neetcode.arrays;

import java.util.HashSet;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
// https://www.youtube.com/watch?v=P6RZZMu_maU
public class _128_Longest_Consecutive_Sequence {

	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : nums) {
			set.add(n);
		}
		int longest = 0;

		for (int n : nums) {
			if (!set.contains(n - 1)) {
				int length = 0;
				while (set.contains(n + length)) {
					length++;
				}
				longest = Math.max(length, longest);
			}
		}

		return longest;

	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [100,4,200,1,3,2]
//		Output: 4
//		Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(new _128_Longest_Consecutive_Sequence().longestConsecutive(nums));

//		Example 2:
//		Input: nums = [0,3,7,2,5,8,4,6,0,1]
//		Output: 9

		nums = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(new _128_Longest_Consecutive_Sequence().longestConsecutive(nums));
	}

}
