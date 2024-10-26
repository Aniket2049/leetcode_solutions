package tuf.arrays1;

// https://leetcode.com/problems/next-permutation/description/
// https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
// https://www.youtube.com/watch?v=JDOXKqF60RQ&t=1s
public class _31_NextPermutation {

	public static void printPermutation(int[] data) {
		System.out.print("The next permutation is: [");
		for (int i = 0; i < data.length; i++) {
			if (i == data.length - 1)
				System.out.print(data[i]);
			else
				System.out.print(data[i] + ",");
		}
		System.out.println("]");
	}

	public static void reverse(int[] a, int start, int end) {
		int i = start, j = end;

		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}

	}

	public void nextPermutation(int[] nums) {
		int n = nums.length; // size of the array.

		// Step 1: Find the break point:
		int index = -1; // break point
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				// index i is the break point
				index = i;
				break;
			}
		}

		// If break point does not exist:
		if (index == -1) {
			// reverse the whole array:
			reverse(nums, 0, nums.length - 1);
			printPermutation(nums);
			return;
		}

		// Step 2: Find the next greater element
		// and swap it with arr[ind]:

		for (int i = n - 1; i > index; i--) {
			if (nums[i] > nums[index]) {
				int tmp = nums[i];
				nums[i] = nums[index];
				nums[index] = tmp;
				break;
			}
		}

		// Step 3: reverse the right half:
		reverse(nums, index + 1, n - 1);

		printPermutation(nums);
	}

	public static void main(String[] args) {
//		Example 0:
//		Input: nums = [2,1,5,4,3,0,0]
//		Output: [2,3,0,0,1,4,5]
		int[] input = new int[] { 2, 1, 5, 4, 3, 0, 0 };
		new _31_NextPermutation().nextPermutation(input);
//		Example 1:
//		Input: nums = [1,2,3]
//		Output: [1,3,2]
		input = new int[] { 1, 2, 3 };
		new _31_NextPermutation().nextPermutation(input);
//		Example 2:
//		Input: nums = [3,2,1]
//		Output: [1,2,3]
		input = new int[] { 3, 2, 1 };
		new _31_NextPermutation().nextPermutation(input);
//		Example 3:
//		Input: nums = [1,1,5]
//		Output: [1,5,1]
		input = new int[] { 1, 1, 5 };
		new _31_NextPermutation().nextPermutation(input);

	}

}
