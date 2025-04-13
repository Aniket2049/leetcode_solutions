package neetcode250.b_twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
// https://www.youtube.com/watch?v=PCGdb-46H_w
public class _12_881_BoatsToSavePeople {
	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);

		int boats = 0;
		int left = 0;
		int right = people.length - 1;
		while (left <= right) {
			if (people[left] + people[right] <= limit) {
				left++;
			}
			right--;
			boats++;
		}
		return boats;
	}
}
