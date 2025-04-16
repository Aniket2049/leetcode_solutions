package neetcode250.c_slidingwindow;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-k-closest-elements/
// https://www.youtube.com/watch?v=Jv5ZB5EXRFw
public class _7_658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l >= k) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
