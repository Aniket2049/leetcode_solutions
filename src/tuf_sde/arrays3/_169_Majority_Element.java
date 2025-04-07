package tuf_sde.arrays3;

// https://leetcode.com/problems/majority-element/description/
// https://www.youtube.com/watch?v=nP_ns3uSh80
public class _169_Majority_Element {

	public int majorityElement(int[] nums) {
		int cnt = 0;
		int el = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (cnt == 0) {
				cnt = 1;
				el = nums[i];
			} else if (nums[i] == el) {
				cnt++;

			} else {
				cnt--;
			}
		}

		int cntFinal = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == el) {
				cntFinal++;
			}
		}

		if (cntFinal > (nums.length / 2)) {
			return el;
		}

		return -1;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [3,2,3]
//		Output: 3
		System.out.println(new _169_Majority_Element().majorityElement(new int[] { 3, 2, 3 }));

//		Example 2:
//		Input: nums = [2,2,1,1,1,2,2]
//		Output: 2
		System.out.println(new _169_Majority_Element().majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));

	}

}
