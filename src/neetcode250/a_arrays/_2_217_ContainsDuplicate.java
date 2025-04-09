package neetcode250.a_arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
// https://www.youtube.com/watch?v=0LIctkgJ2hQ
public class _2_217_ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> myset = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (myset.contains(nums[i]))
				return true;
			else
				myset.add(nums[i]);
		}

		return false;
	}
}
