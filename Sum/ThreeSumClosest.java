//https://leetcode.com/problems/3sum-closest/submissions/
package Sum;

import Utils.Utils;
import java.util.Arrays;

public class ThreeSumClosest {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		ThreeSumClosest cn = new ThreeSumClosest();

		utils.printLine(cn.threeSumClosest(new int[] { -3, -2, -5, 3, -4 }, -1));

	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int rem, right = nums.length - 1, left, nsum, ans = nums[nums.length - 1] * 3;
		for (int i = 0; i < nums.length; i++) {
			left = i + 1;
			right = nums.length - 1;
			rem = target - nums[i];
			while (left < right) {
				nsum = nums[left] + nums[right];
				if (nsum > rem)
					right--;
				else if (nsum < rem)
					left++;
				else
					return nsum + nums[i];
				ans = Math.abs(target - (nsum + nums[i])) < Math.abs(target - ans) ? nsum + nums[i] : ans;
			}
		}
		return ans;
	}
}
