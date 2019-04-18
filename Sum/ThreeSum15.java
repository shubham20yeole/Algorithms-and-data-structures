//https://leetcode.com/problems/3sum/
package Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum15 {

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> ans = new HashSet<List<Integer>>();

		threeSumUtils(ans, nums);
		return new ArrayList<>(ans);
	}

	public void threeSumUtils(Set<List<Integer>> ans, int[] nums) {

		int lind, left, right, curr;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			lind = i - 1;
			curr = nums[i];
			while (lind >= 0) {
				left = nums[lind];

				if (Arrays.binarySearch(nums, i + 1, nums.length, -(left + curr)) >= 0) {
					List<Integer> sub = new ArrayList<Integer>();
					sub.add(left);
					sub.add(curr);
					sub.add(-(left + curr));
					ans.add(sub);
				}

				lind--;
			}
		}
	}
}
