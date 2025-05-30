package neetcode250.a_arrays;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/
// https://www.youtube.com/watch?v=XjP2mQr98WQ
// https://www.youtube.com/watch?v=fFVZt-6sgyo
public class _21_560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
    	int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) count++;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
