package tuf_sde.stack_queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/description/
// https://www.youtube.com/watch?v=68a1Dc_qVq4
public class _496_Next_Greater_Element_I {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums2.length == 0 || nums1.length == 0)
			return new int[0];

		Map<Integer, Integer> numberNGE = new HashMap<>();
		Stack<Integer> numStack = new Stack<>();

		numStack.push(nums2[nums2.length - 1]);
		numberNGE.put(nums2[nums2.length - 1], -1);

		for (int i = nums2.length - 2; i >= 0; i--) {

			if (nums2[i] < numStack.peek()) {
				numberNGE.put(nums2[i], numStack.peek());
				numStack.push(nums2[i]);
				continue;
			}

			while (!numStack.isEmpty() && numStack.peek() < nums2[i])
				numStack.pop();

			if (numStack.isEmpty()) {
				numStack.push(nums2[i]);
				numberNGE.put(nums2[i], -1);
			} else {
				numberNGE.put(nums2[i], numStack.peek());
				numStack.push(nums2[i]);
			}
		}

		for (int i = 0; i < nums1.length; i++)
			nums1[i] = numberNGE.get(nums1[i]);

		return nums1;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//		Output: [-1,3,-1]
//		Explanation: The next greater element for each value of nums1 is as follows:
//		- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//		- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//		- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
		System.out.println(Arrays.toString(
				new _496_Next_Greater_Element_I().nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));

//		Example 2:
//		Input: nums1 = [2,4], nums2 = [1,2,3,4]
//		Output: [3,-1]
//		Explanation: The next greater element for each value of nums1 is as follows:
//		- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
//		- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

		System.out.println(Arrays.toString(
				new _496_Next_Greater_Element_I().nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })));

	}

}
