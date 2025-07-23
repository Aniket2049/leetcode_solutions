package neetcode250.r_bitmanipulation;

// https://leetcode.com/problems/add-binary/
// https://www.youtube.com/watch?v=keuWJ47xG8g
public class _04_67_AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		int carry = 0;

		StringBuilder sa = new StringBuilder(a).reverse();
		StringBuilder sb = new StringBuilder(b).reverse();

		for (int i = 0; i < Math.max(sa.length(), sb.length()); i++) {
			int digitA = i < sa.length() ? sa.charAt(i) - '0' : 0;
			int digitB = i < sb.length() ? sb.charAt(i) - '0' : 0;

			int total = digitA + digitB + carry;
			char c = (char) ((total % 2) + '0');
			res.append(c);
			carry = total / 2;
		}

		if (carry > 0) {
			res.append('1');
		}

		return res.reverse().toString();
	}
}
