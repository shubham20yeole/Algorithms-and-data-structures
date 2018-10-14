//https://leetcode.com/problems/maximum-product-subarray
package Array;

import Utils.Utils;

public class MaximumProductSubarray152 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		MaximumProductSubarray152 cn = new MaximumProductSubarray152();

		utils.printLine(cn.maxProduct(new int[] { 1, -3, 2, -4 }));

	}

	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		int res = nums[0], min = nums[0], max = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}

			max = Math.max(nums[i] * max, nums[i]);
			min = Math.min(nums[i] * min, nums[i]);
			res = Math.max(res, max);
		}

		return res;
	}
}
