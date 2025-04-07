package tuf_sde.string;

import java.util.HashMap;

// https://leetcode.com/problems/roman-to-integer/
public class _13_Roman_to_Integer {

	public int romanToInt(String s) {
		HashMap<Character, Integer> order = new HashMap<Character, Integer>();
		order.put('I', 1);
		order.put('V', 5);
		order.put('X', 10);
		order.put('L', 50);
		order.put('C', 100);
		order.put('D', 500);
		order.put('M', 1000);

		int integerAnswer = 0;
		int prevCharOrder = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			Character currentChar = s.charAt(i);
			int currentCharOrder = order.get(currentChar);
			if (currentCharOrder >= prevCharOrder) {
				integerAnswer += currentCharOrder;
			} else {
				integerAnswer -= currentCharOrder;
			}
			prevCharOrder = currentCharOrder;
		}

		return integerAnswer;

	}

	public static void main(String[] args) {
		System.out.println(new _13_Roman_to_Integer().romanToInt("III"));
		System.out.println(new _13_Roman_to_Integer().romanToInt("LVIII"));
		System.out.println(new _13_Roman_to_Integer().romanToInt("MCMXCIV"));

	}

}
