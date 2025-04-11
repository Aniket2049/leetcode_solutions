package neetcode250.a_arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
// https://www.youtube.com/watch?v=P6RZZMu_maU
public class _18_128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
