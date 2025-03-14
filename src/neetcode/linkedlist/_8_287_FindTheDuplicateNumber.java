package neetcode.linkedlist;

// https://leetcode.com/problems/find-the-duplicate-number/description/
// https://www.youtube.com/watch?v=_n5MR8IxR6c
public class _8_287_FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		// Start a fast and slow pointer
		// until they meet
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// As soon as they meet, move both
		// pointers at same speed until they
		// meet again
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
