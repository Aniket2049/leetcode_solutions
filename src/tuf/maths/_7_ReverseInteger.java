package tuf.maths;

// https://leetcode.com/problems/reverse-integer/description/
// https://www.youtube.com/watch?v=HAgLH58IgJQ
// https://leetcode.com/problems/reverse-integer/solutions/5428589/video-using-remainder/
// https://www.youtube.com/watch?v=Y_NCKgC3BiM
public class _7_ReverseInteger {

	public int reverse(int x) {
		int reversed = 0;
		while (x != 0) {
			int digit = x % 10;
			x /= 10;
			if (reversed > Integer.MAX_VALUE / 10
					|| (reversed == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
				return 0;
			if (reversed < Integer.MIN_VALUE / 10
					|| (reversed == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10))
				return 0;
			reversed = reversed * 10 + digit;
		}
		return reversed;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: x = 123
//		Output: 321
//		
//		Example 2:
//		Input: x = -123
//		Output: -321
//		
//		Example 3:
//		Input: x = 120
//		Output: 21

		_7_ReverseInteger obj = new _7_ReverseInteger();
		System.out.println(obj.reverse(321));
		System.out.println(obj.reverse(-123));
		System.out.println(obj.reverse(Integer.MAX_VALUE));

	}

}
