package neetcode250.e_binarysearch;

// https://leetcode.com/problems/find-in-mountain-array/
// https://www.youtube.com/watch?v=BGgYC-YkGvc
public class _14_1095_FindInMountainArray {
	public int findInMountainArray(int target, MountainArray mountainArr) {
		int length = mountainArr.length();

		// Find Peak
		int l = 1, r = length - 2, peak = 0;
		while (l <= r) {
			int m = (l + r) / 2;
			int left = mountainArr.get(m - 1);
			int mid = mountainArr.get(m);
			int right = mountainArr.get(m + 1);
			if (left < mid && mid < right) {
				l = m + 1;
			} else if (left > mid && mid > right) {
				r = m - 1;
			} else {
				peak = m;
				break;
			}
		}

		// Search left portion
		l = 0;
		r = peak - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			int val = mountainArr.get(m);
			if (val < target) {
				l = m + 1;
			} else if (val > target) {
				r = m - 1;
			} else {
				return m;
			}
		}

		// Search right portion
		l = peak;
		r = length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			int val = mountainArr.get(m);
			if (val > target) {
				l = m + 1;
			} else if (val < target) {
				r = m - 1;
			} else {
				return m;
			}
		}

		return -1;
	}
}
