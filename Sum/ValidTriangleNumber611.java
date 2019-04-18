//
package Sum;

import Utils.Utils;
import java.util.Arrays;

public class ValidTriangleNumber611 {
	static Utils utils = new Utils();
	Utils util = new Utils();

	public static void main(String[] args) {
		ValidTriangleNumber611 cn = new ValidTriangleNumber611();
		utils.printLine(cn.triangleNumber(new int[] { 24, 3, 82, 22, 35, 84, 19 }));
	}

	public int triangleNumber(int[] nums) {
		int l, r, ref, ans = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			ref = nums[i];

			// IMPORTANT CONDITION as triangle can never have any side of 0 length
			// [0,1,0]
			if (ref == 0)
				continue;
			l = i + 1;
			r = nums.length - 1;

			// we dont need l < r condition here because even if l > r we need to move l one
			// step forward to check rest of the possibilities
			while (l < nums.length - 1) {

				// IMPORTANT CONDITION as even if l > r we need to move l one
				// step forward to check rest of the possibilities
				// [3, 19, 22, 24, 35, 82, 84]
				if (l > r) {
					l++;
					r = nums.length - 1;
					continue;
				}
				if (nums[r] < ref + nums[l]) {
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
