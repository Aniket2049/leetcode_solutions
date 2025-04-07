package tuf_sde.arrays2;

// https://leetcode.com/problems/find-the-duplicate-number/
// https://leetcode.com/problems/find-the-duplicate-number/solutions/4916443/interview-approach-7-approaches/
// https://www.youtube.com/watch?v=wjYnzkAhcNk
public class _287_Find_the_Duplicate_Number {

	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return fast;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,3,4,2,2]
//		Output: 2

		System.out.println(new _287_Find_the_Duplicate_Number().findDuplicate(new int[] { 1, 3, 4, 2, 2 }));

//		Example 2:
//		Input: nums = [3,1,3,4,2]
//		Output: 3

		System.out.println(new _287_Find_the_Duplicate_Number().findDuplicate(new int[] { 3, 1, 3, 4, 2 }));

//		Example 3:
//		Input: nums = [3,3,3,3,3]
//		Output: 3

		System.out.println(new _287_Find_the_Duplicate_Number().findDuplicate(new int[] { 3, 3, 3, 3, 3 }));
	}

}
