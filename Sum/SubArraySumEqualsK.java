//https://leetcode.com/problems/subarray-sum-equals-k/
package Sum;

import Utils.Utils;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		SubArraySumEqualsK cn = new SubArraySumEqualsK();

		utils.printLine(cn.subarraySum(new int[] { 1, 4, 6, 3, 2, 5, 9, 7 }, 16));

	}

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

		hm.put(0, 1);

		for (int num : nums) {

			sum = sum + num;

			if (hm.containsKey(sum - k))
				count = count + hm.get(sum - k);

			hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}
