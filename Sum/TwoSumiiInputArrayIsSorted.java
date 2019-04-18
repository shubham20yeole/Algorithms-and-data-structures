//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
package Sum;

public class TwoSumiiInputArrayIsSorted {

	public int[] twoSum(int[] nums, int target) {
		int l = 0, r = nums.length - 1, nsum;
		int[] ans = new int[2];
		while (l < r) {
			nsum = nums[l] + nums[r];
			if (nsum > target)
				r--;
			else if (nsum < target)
				l++;
			else {
				ans[0] = l + 1;
				ans[1] = r + 1;
				return ans;
			}
		}

		return ans;
	}
}
