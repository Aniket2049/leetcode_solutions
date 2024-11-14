package tuf.arrays3;

// https://leetcode.com/problems/powx-n/description/
// https://www.youtube.com/watch?v=hFWckDXE-K8
public class _50_Pow_x_n {

	public double myPow(double x, int n) {
		double ans = 1.0;
		long nn = n;
		if (nn < 0)
			nn = -1 * nn;
		while (nn > 0) {
			if (nn % 2 == 1) {
				ans = ans * x;
				nn = nn - 1;
			} else {
				x = x * x;
				nn = nn / 2;
			}
		}
		if (n < 0)
			ans = (double) (1.0) / (double) (ans);
		return ans;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: x = 2.00000, n = 10
//		Output: 1024.00000
		System.out.println(new _50_Pow_x_n().myPow(2.000, 10));

//		Example 2:
//		Input: x = 2.10000, n = 3
//		Output: 9.26100
		System.out.println(new _50_Pow_x_n().myPow(2.100, 3));

//		Example 3:
//		Input: x = 2.00000, n = -2
//		Output: 0.25000
//		Explanation: 2-2 = 1/22 = 1/4 = 0.25
		System.out.println(new _50_Pow_x_n().myPow(2.000, -2));

	}

}
