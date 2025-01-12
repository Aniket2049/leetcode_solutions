package tuf.string2;

// https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
// https://www.youtube.com/watch?v=zL0O6Q6kEAQ
public class Minimum_Characters_required_to_make_a_String_Palindromic {

	public int solve(String A) {
		int i = 0;
		int j = A.length() - 1;
		int trim = j;
		int res = 0;

		while (i < j) {
			if (A.charAt(i) == A.charAt(j)) {
				i++;
				j--;
			} else {
				res++;
				i = 0;
				j = --trim;
			}
		}
		return res;
	}

	public static void main(String[] args) {
//		Example Input
//		Input 1:
//		A = "ABC"
//		Input 2:
//		A = "AACECAAAA"
//		Example Output
//		Output 1:
//		2
//		Output 2:
//		2
//		Example Explanation
//		Explanation 1:
//		Insert 'B' at beginning, string becomes: "BABC".
//		Insert 'C' at beginning, string becomes: "CBABC".
//		Explanation 2:
//		Insert 'A' at beginning, string becomes: "AAACECAAAA".
//		Insert 'A' at beginning, string becomes: "AAAACECAAAA".

		System.out.println(new Minimum_Characters_required_to_make_a_String_Palindromic().solve("ABC"));
		System.out.println(new Minimum_Characters_required_to_make_a_String_Palindromic().solve("AACECAAAA"));
	}

}
