package tuf.maths;

// https://leetcode.com/problems/palindrome-number/description/
// https://youtu.be/1xNbjMdbjug?t=1273
public class _9_PalindromeNumber {

	public boolean isPalindrome(int x) {

        int revNum = 0;
        int dup = x;
        while (x > 0) {
            int ld = x % 10;
            revNum = (revNum * 10) + ld;
            x = x / 10;
        }

        if (dup == revNum) {
            return true;
        } else {
            return false;
        }
    }
	
	public static void main(String[] args) {
		_9_PalindromeNumber obj = new _9_PalindromeNumber();
		System.out.println(obj.isPalindrome(1331));
		System.out.println(obj.isPalindrome(1356));

	}

}
