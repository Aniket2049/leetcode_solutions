package tuf.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/
public class PrintAllDivisors {
	public static void printDivisors(int n) {
		List<Integer> factors = new ArrayList<Integer>();
		int sqrtOfN = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrtOfN; i++) {
			if (n % i == 0) {
				factors.add(i);
				if ((n / i) != i) {
					factors.add(n / i);
				}
			}
		}
		Collections.sort(factors);
		System.out.println(factors.toString());
	}

	public static void main(String[] args) {
		printDivisors(50);
	}
}
