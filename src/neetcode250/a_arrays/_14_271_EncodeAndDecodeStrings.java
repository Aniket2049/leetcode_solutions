package neetcode250.a_arrays;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/string-encode-and-decode
// https://www.lintcode.com/problem/659/
// https://www.youtube.com/watch?v=B1k_sxOSgv8
public class _14_271_EncodeAndDecodeStrings {

	public String encode(List<String> strs) {
		StringBuilder res = new StringBuilder();
		for (String s : strs) {
			res.append(s.length()).append('#').append(s);
		}
		return res.toString();
	}

	public List<String> decode(String str) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int j = i;
			while (str.charAt(j) != '#') {
				j++;
			}
			int length = Integer.parseInt(str.substring(i, j));
			i = j + 1;
			j = i + length;
			res.add(str.substring(i, j));
			i = j;
		}
		return res;
	}
}
