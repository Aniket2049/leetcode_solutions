package neetcode250.o_greedy;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/dota2-senate/
// https://www.youtube.com/watch?v=zZA5KskfMuQ
public class _10_649_Dota2Senate {
	public String predictPartyVictory(String senate) {
		Queue<Integer> R = new LinkedList<>();
		Queue<Integer> D = new LinkedList<>();
		int n = senate.length();

		for (int i = 0; i < n; i++) {
			if (senate.charAt(i) == 'R') {
				R.add(i);
			} else {
				D.add(i);
			}
		}

		while (!R.isEmpty() && !D.isEmpty()) {
			int rTurn = R.poll();
			int dTurn = D.poll();

			if (rTurn < dTurn) {
				R.add(rTurn + n);
			} else {
				D.add(dTurn + n);
			}
		}

		return R.isEmpty() ? "Dire" : "Radiant";
	}
}
