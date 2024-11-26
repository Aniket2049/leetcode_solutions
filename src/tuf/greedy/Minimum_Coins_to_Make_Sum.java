package tuf.greedy;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
// https://takeuforward.org/data-structure/find-minimum-number-of-coins/
public class Minimum_Coins_to_Make_Sum {

	public static void main(String[] args) {
//		Example 1:
//		Input: V = 70
//		Output: 2
//		Explaination: We need a 50 Rs note and a 20 Rs note.

//		Example 2:
//		Input: V = 121
//		Output: 3
//		Explaination: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.

		int V = 49;
		ArrayList<Integer> ans = new ArrayList<>();
		int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int n = coins.length;
		for (int i = n - 1; i >= 0; i--) {
			while (V >= coins[i]) {
				V -= coins[i];
				ans.add(coins[i]);
			}
		}
		System.out.println("The minimum number of coins is " + ans.size());
		System.out.println("The coins are ");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(" " + ans.get(i));
		}
	}

}
