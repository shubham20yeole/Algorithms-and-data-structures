//https://leetcode.com/problems/3sum-smaller/
package Sum;

import java.util.Arrays;

public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		int l, r, ans = 0, nsum, rem;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			l = i + 1;
			r = nums.length - 1;
			rem = target - nums[i];
			while (l < r) {
				nsum = nums[l] + nums[r];
				if (nsum < rem) {
					ans = ans + r - (l + 1) + 1;
					l++;
					r = nums.length - 1;
				} else
					r--;
			}
		}
		return ans;
	}
}
