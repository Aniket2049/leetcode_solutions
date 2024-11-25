package tuf.linkedlistarrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// https://youtu.be/37E9ckMDdTk?t=1886
public class _26_Remove_Duplicates_from_Sorted_Array {

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums = [1,1,2]
//		Output: 2, nums = [1,2,_]
//		Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//		It does not matter what you leave beyond the returned k (hence they are underscores).
		System.out.println(new _26_Remove_Duplicates_from_Sorted_Array().removeDuplicates(new int[] { 1, 1, 2 }));

//		Example 2:
//		Input: nums = [0,0,1,1,1,2,2,3,3,4]
//		Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//		Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//		It does not matter what you leave beyond the returned k (hence they are underscores).
		System.out.println(new _26_Remove_Duplicates_from_Sorted_Array()
				.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));

	}

}
