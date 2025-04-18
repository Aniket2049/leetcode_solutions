package profound.a_implementation;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/implementation-problems-ObQiMm0v1df0p473h5H2

/*
Challenge - Find the missing number
Given all the numbers from 1 to n except one, you are asked to find the missing number.

Input
The first line of the input contains a single integer n (2≤ n ≤ 100 000).
The second line of the input contains n+1 space-separated integers a₁ (1 ≤ a ≤ n).

Output
The program should print the missing number.

Examples
+-------------------------------+
|Input        	|Output			|
+---------------+---------------+
|4				|2				|
|341			|				|
+---------------+---------------+
|3				|3				|
|21				|				|
+-------------------------------+
*/

public class _1_FindTheMissingNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			numbers[i] = scanner.nextInt();
		}
		scanner.close();

		//--------------

		int allXOR = 0;
		for (int i = 1; i <= n; i++) {
			allXOR = allXOR ^ i;
		}
		for (int num : numbers) {
			allXOR = allXOR ^ num;
		}

		System.out.println(allXOR);
	}
}
