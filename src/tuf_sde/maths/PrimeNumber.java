package tuf_sde.maths;

// https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/
public class PrimeNumber {
	public static void checkIfPrime(int n) {
		int count = 0;
		int sqrtOfN = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrtOfN; i++) {
			if (n % i == 0) {
				count++;
				if ((n / i) != i) {
					count++;
				}
			}
		}

		System.out.println(count == 2 ? "true" : "false");
	}

	public static void main(String[] args) {
		checkIfPrime(50);
		checkIfPrime(17);
	}
}
