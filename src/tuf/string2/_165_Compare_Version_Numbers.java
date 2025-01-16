package tuf.string2;

// https://leetcode.com/problems/compare-version-numbers/description/
// https://www.youtube.com/watch?v=Z4Af1_t7wzk
public class _165_Compare_Version_Numbers {

	public int compareVersion(String version1, String version2) {
		int temp1 = 0, temp2 = 0;
		int len1 = version1.length(), len2 = version2.length();
		int i = 0, j = 0;
		while (i < len1 || j < len2) {
			temp1 = 0;
			temp2 = 0;
			while (i < len1 && version1.charAt(i) != '.') {
				temp1 = temp1 * 10 + version1.charAt(i++) - '0';
			}
			while (j < len2 && version2.charAt(j) != '.') {
				temp2 = temp2 * 10 + version2.charAt(j++) - '0';
			}
			if (temp1 > temp2)
				return 1;
			else if (temp1 < temp2)
				return -1;
			else {
				i++;
				j++;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: version1 = "1.2", version2 = "1.10"
//		Output: -1
//		Explanation:
//		version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.
		System.out.println(new _165_Compare_Version_Numbers().compareVersion("1.2", "1.10"));

//		Example 2:
//		Input: version1 = "1.01", version2 = "1.001"
//		Output: 0
//		Explanation:
//		Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
		System.out.println(new _165_Compare_Version_Numbers().compareVersion("1.01", "1.001"));

//		Example 3:
//		Input: version1 = "1.0", version2 = "1.0.0.0"
//		Output: 0
//		Explanation:
//		version1 has less revisions, which means every missing revision are treated as "0".
		System.out.println(new _165_Compare_Version_Numbers().compareVersion("1.0", "1.0.0.0"));

	}

}
