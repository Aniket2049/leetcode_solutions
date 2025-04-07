package neetcode150.binarysearch;

// https://leetcode.com/problems/koko-eating-bananas/description/
// https://www.youtube.com/watch?v=ceYZ5RgwQwQ
public class _3_875_KokoEatingBananas {

	private boolean helper(int k, int[] piles, int h) {
		int hours = 0;
		for (int pile : piles) {
			int hoursToEatPile = pile / k;
			hours += hoursToEatPile;
			if (pile % k != 0)
				hours++;
		}

		return hours <= h;
	}

	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int max = piles[0];
		for (int i = 0; i < piles.length; i++) {
			if (piles[i] > max)
				max = piles[i];
		}
		int right = max;

		while (left < right) {
			int mid = (left + right) / 2;
			if (helper(mid, piles, h))
				right = mid;
			else
				left = mid + 1;
		}

		return left;
	}

	public static void main(String[] args) {
		int[] piles = new int[] { 3, 6, 7, 11 };
		int h = 8;
		System.out.println(new _3_875_KokoEatingBananas().minEatingSpeed(piles, h));

		piles = new int[] { 30, 11, 23, 4, 20 };
		h = 5;
		System.out.println(new _3_875_KokoEatingBananas().minEatingSpeed(piles, h));

		piles = new int[] { 30, 11, 23, 4, 20 };
		h = 6;
		System.out.println(new _3_875_KokoEatingBananas().minEatingSpeed(piles, h));

	}

}
