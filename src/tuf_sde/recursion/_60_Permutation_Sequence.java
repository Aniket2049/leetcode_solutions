package tuf_sde.recursion;

import java.util.ArrayList;

// https://leetcode.com/problems/permutation-sequence/description/
// https://www.youtube.com/watch?v=wT7gcXLYoao
public class _60_Permutation_Sequence {

	public String getPermutation(int n, int k) {
		int fact = 1;
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			fact = fact * i;
			numbers.add(i);
		}
		numbers.add(n);
		String ans = "";
		k = k - 1;
		while (true) {
			ans = ans + "" + numbers.get(k / fact);
			numbers.remove(k / fact);
			if (numbers.size() == 0) {
				break;
			}

			k = k % fact;
			fact = fact / numbers.size();
		}
		return ans;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: n = 3, k = 3
//		Output: "213"
		System.out.println(new _60_Permutation_Sequence().getPermutation(3, 3));

//		Example 2:
//		Input: n = 4, k = 9
//		Output: "2314"
		System.out.println(new _60_Permutation_Sequence().getPermutation(4, 9));

//		Example 3:
//		Input: n = 3, k = 1
//		Output: "123"
		System.out.println(new _60_Permutation_Sequence().getPermutation(3, 1));

	}

}
