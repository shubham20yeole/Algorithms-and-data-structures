//https://leetcode.com/problems/subsets
package Array;

import Utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		Subsets78 cn = new Subsets78();
		System.out.println(cn.subsets(new int[] { 1, 2, 5 }));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, new ArrayList<Integer>(), nums, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
		res.add(new ArrayList<Integer>(list));

		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			helper(res, list, nums, start + 1);
			list.remove(list.size() - 1);
		}
	}
}
