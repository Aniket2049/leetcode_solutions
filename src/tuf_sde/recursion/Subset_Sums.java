package tuf_sde.recursion;

import java.util.ArrayList;
import java.util.Collections;

// https://www.geeksforgeeks.org/problems/subset-sums2234/1
// https://www.youtube.com/watch?v=rYkfBRtMJr8
// https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
public class Subset_Sums {

	static void subsetSumsHelper(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
		if (ind == N) {
			sumSubset.add(sum);
			return;
		}

		// pick the element
		subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

		// Do-not pick the element
		subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
	}

	static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {

		ArrayList<Integer> sumSubset = new ArrayList<>();
		subsetSumsHelper(0, 0, arr, N, sumSubset);
		Collections.sort(sumSubset);
		return sumSubset;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: N = 3, arr[] = {5,2,1}
//		Output: 0,1,2,3,5,6,7,8
//		Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(1);
		arr.add(2);
		ArrayList<Integer> ans = subsetSums(arr, arr.size());
		Collections.sort(ans);
		System.out.println("The sum of each subset is ");
		for (int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");

//		Example 2:
//		Input: N=3,arr[]= {3,1,2}
//		Output: 0,1,2,3,3,4,5,6
//		Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6

	}

}
