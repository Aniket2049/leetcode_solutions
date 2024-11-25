package tuf.linkedlistarrays;

// https://leetcode.com/problems/max-consecutive-ones/description/
public class _485_Max_Consecutive_Ones {

	public int findMaxConsecutiveOnes(int[] nums) {
		int i = 0;
		int max = 0;
		int current = 0;
		while (i < nums.length) {
			if (nums[i] == 1) {
				current++;
			} else {
				current = 0;
			}
			max = Math.max(max, current);
			i++;
		}

		return max;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,1,0,1,1,1]
//		Output: 3
//		Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
		System.out.println(new _485_Max_Consecutive_Ones().findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));

//		Example 2:
//		Input: nums = [1,0,1,1,0,1]
//		Output: 2
		System.out.println(new _485_Max_Consecutive_Ones().findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));

	}

}
