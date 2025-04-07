package tuf_sde.string2;

// https://leetcode.com/problems/count-and-say/description/
// https://www.youtube.com/watch?v=VE8yEc4R6q0
public class _38_Count_and_Say {

	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		String res = "1";
		for (int i = 2; i <= n; i++) {
			res = countAndSayHelper(res);
		}
		return res;
	}

	public String countAndSayHelper(String s) {
		char ch = s.charAt(0);
		int count = 1;
		int l = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < l; i++) {
			if (s.charAt(i) != ch) {
				sb.append(count).append(ch);
				ch = s.charAt(i);
				count = 1;
			} else {
				count += 1;
			}
		}
		sb.append(count).append(ch);
		return sb.toString();
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: n = 4
//		Output: "1211"
//		Explanation:
//		countAndSay(1) = "1"
//		countAndSay(2) = RLE of "1" = "11"
//		countAndSay(3) = RLE of "11" = "21"
//		countAndSay(4) = RLE of "21" = "1211"
		System.out.println(new _38_Count_and_Say().countAndSay(4));

//		Example 2:
//		Input: n = 1
//		Output: "1"
//		Explanation:
//		This is the base case.
		System.out.println(new _38_Count_and_Say().countAndSay(1));

	}

}
