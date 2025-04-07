package neetcode150.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/encode-and-decode-strings/description/
// https://www.youtube.com/watch?v=B1k_sxOSgv8
// https://neetcode.io/problems/string-encode-and-decode
public class _6_271_EncodeDecodeStrings {

	public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
	}

	public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: ["neet","code","love","you"]
//		Output:["neet","code","love","you"]

		List<String> input = Arrays.asList("neet", "code", "love", "you");
		List<String> output = Arrays.asList("neet", "code", "love", "you");
		String encoded = new _6_271_EncodeDecodeStrings().encode(input);
		List<String> decoded = new _6_271_EncodeDecodeStrings().decode(encoded);
		System.out.println(encoded);
		System.out.println(Arrays.toString(decoded.toArray()));
		
//		Example 2:
//		Input: ["we","say",":","yes"]
//		Output: ["we","say",":","yes"]
		input = Arrays.asList("we","say",":","yes");
		output = Arrays.asList("we","say",":","yes");
		encoded = new _6_271_EncodeDecodeStrings().encode(input);
		decoded = new _6_271_EncodeDecodeStrings().decode(encoded);
		System.out.println(encoded);
		System.out.println(Arrays.toString(decoded.toArray()));

	}

}
