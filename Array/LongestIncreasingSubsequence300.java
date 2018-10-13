//https://leetcode.com/problems/longest-increasing-subsequence/description/
package Array;
import java.util.*;
import Utils.*;

public class LongestIncreasingSubsequence300 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		LongestIncreasingSubsequence300 cn = new LongestIncreasingSubsequence300();
		
		System.out.println(cn.lengthOfLIS(new int[] { 10,9,2,5,3,7,101,18,200 }));
		System.out.println(cn.lengthOfLIS(new int[] { 1, 5, 3, 6, 2, 7, 101 }));
		System.out.println(cn.lengthOfLIS(new int[] { 2, 2 }));
		System.out.println(cn.lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
	}
	
	public int lengthOfLIS(int[] nums) {
    int max = 0;
		if(nums.length == 0) return max;
		int min = nums[0];
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			int maxVal = 0;
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					maxVal = Math.max(maxVal, dp[j]);
				}
				dp[i] = maxVal + 1;
				max = Math.max(max, dp[i]);
			}
		}
		
    return max;
  }
	
	public int lengthOfLIS2(int[] nums) {
    int max = 0;
		if(nums.length == 0) return max;
		int min = nums[0];
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(min);
		max = s.size();
		for (int i = 1; i < nums.length; i++) {
			int cur = nums[i];
			if(cur <= min) {
				min = cur;
				s.clear();
				s.push(min);
				continue;
			} else {
				if(!s.isEmpty() && cur < s.peek()) {
					while(true) {
						if(s.isEmpty()) break;
						int peek = s.peek();
						if(cur > peek) break;
						s.pop();
					}
					s.push(cur);
				} else {
					s.push(cur);
					max = Math.max(max, s.size());
				}
			}
			System.out.println(s);
		}
		
    return max;
  }
}

