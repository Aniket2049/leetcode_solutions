package tuf.arrays;

// https://leetcode.com/problems/maximum-subarray/description/
// https://www.youtube.com/watch?v=5WZl3MMT0Eg
public class _53_MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int maxSub = nums[0];
		int currSum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (currSum < 0)
				currSum = 0;

			currSum = currSum + nums[i];
			maxSub = Math.max(maxSub, currSum);
		}

		return maxSub;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
//		Output: 6 
		System.out.println(new _53_MaximumSubarray().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
//		Examples 2:
//		Input: arr = [1] 
//		Output: 1 
		System.out.println(new _53_MaximumSubarray().maxSubArray(new int[] { 1 }));
	}

}
