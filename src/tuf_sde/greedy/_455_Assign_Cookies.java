package tuf_sde.greedy;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/description/
// 
public class _455_Assign_Cookies {

	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int index = 0;
		int cnt = 0;

		while (index < s.length && cnt < g.length) {
			if (s[index] >= g[cnt]) {
				cnt++;
			}
			index++;
		}

		return cnt;
	}

	public static void main(String[] args) {
//		Example 1:
//		Input: g = [1,2,3], s = [1,1]
//		Output: 1
//		Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
//		And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
//		You need to output 1.
		System.out.println(new _455_Assign_Cookies().findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));

//		Example 2:
//		Input: g = [1,2], s = [1,2,3]
//		Output: 2
//		Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
//		You have 3 cookies and their sizes are big enough to gratify all of the children, 
//		You need to output 2.
		System.out.println(new _455_Assign_Cookies().findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));

	}

}
