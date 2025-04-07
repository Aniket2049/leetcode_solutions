package tuf_sde.arrays3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/majority-element-ii/description/
// https://www.youtube.com/watch?v=vwZj1K0e9U8 
public class _229_Majority_Element_II {

	public List<Integer> majorityElement(int[] nums) {
		int cnt1 = 0;
		int cnt2 = 0;
		int el1 = Integer.MIN_VALUE;
		int el2 = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (cnt1 == 0 && nums[i] != el2) {
				cnt1 = 1;
				el1 = nums[i];
			} else if (cnt2 == 0 && nums[i] != el1) {
				cnt2 = 1;
				el2 = nums[i];
			} else if (nums[i] == el1)
				cnt1++;
			else if (nums[i] == el2)
				cnt2++;
			else {
				cnt1--;
				cnt2--;
			}
		}

		List<Integer> ans = new ArrayList<Integer>();
		cnt1 = 0;
		cnt2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == el1)
				cnt1++;
			if (nums[i] == el2)
				cnt2++;
		}

		int min = (nums.length / 3) + 1;
		if (cnt1 >= min)
			ans.add(el1);
		if (cnt2 >= min)
			ans.add(el2);

//		Collections.sort(ans);

		return ans;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [3,2,3]
//		Output: [3]
		System.out.println(new _229_Majority_Element_II().majorityElement(new int[] { 3, 2, 3 }).toString());

//		Example 2:
//		Input: nums = [1]
//		Output: [1]
		System.out.println(new _229_Majority_Element_II().majorityElement(new int[] { 2 }).toString());

//		Example 3:
//		Input: nums = [1,2]
//		Output: [1,2]
		System.out.println(new _229_Majority_Element_II().majorityElement(new int[] { 1, 2 }).toString());

	}

}
