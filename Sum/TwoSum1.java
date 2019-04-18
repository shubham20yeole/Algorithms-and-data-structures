//https://leetcode.com/problems/two-sum/
package Sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

	public int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];

		if (nums.length < 2)
			return ans;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(nums[0], 0);

		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];
			if (map.containsKey(target - curr)) {
				ans[0] = map.get(target - curr);
				ans[1] = i;
				break;
			}

			map.put(curr, i);
		}
		return ans;
	}
}
