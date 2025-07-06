package neetcode250.o_greedy;

// https://leetcode.com/problems/valid-parenthesis-string/
// https://www.youtube.com/watch?v=QhPdNS143Qg
public class _13_678_ValidParenthesisString {
	public boolean checkValidString(String s) {
		int leftMin = 0, leftMax = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				leftMin++;
				leftMax++;
			} else if (c == ')') {
				leftMin--;
				leftMax--;
			} else {
				leftMin--;
				leftMax++;
			}
			if (leftMax < 0) {
				return false;
			}
			if (leftMin < 0) {
				leftMin = 0;
			}
		}
		return leftMin == 0;
	}
}
