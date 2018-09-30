//https://leetcode.com/problems/subarray-sum-equals-k
package Array;

import java.util.*;

public class SubarraySumEqualsK560 {
	public static void main(String[] args) {
		
		SubarraySumEqualsK560 cn = new SubarraySumEqualsK560();
		
		int[] ar = { 3, 4, 7, 2, -3, 1, 4, 2};
		
		System.out.println(cn.subarraySum(ar, 7));
	}
	
	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		hm.put(0, 1);
		
		for (int num : nums) {
			
			sum = sum + num;
			
			if (hm.containsKey(sum - k)) count = count + hm.get(sum - k);
			
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);			
		}
		
        return count;
    }
}
