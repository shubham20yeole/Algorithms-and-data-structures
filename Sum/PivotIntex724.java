//https://leetcode.com/problems/find-pivot-index/
// Check solution for better answer
package Sum;

public class PivotIntex724 {

	public int pivotIndex(int[] nums) {
		int ans = -1, sum = 0;

		int[] l = new int[nums.length];
		int[] r = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			l[i] = sum;
		}
		sum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			sum += nums[i];
			r[i] = sum;
		}

		for (int i = 0; i < nums.length; i++) {
			if (l[i] == r[i] || ((i > 0 && i < nums.length - 1) && l[i - 1] == r[i + 1]))
				return i;
		}

		return ans;
	}
}
