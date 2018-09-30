//https://leetcode.com/problems/combination-sum/description/
package Array;
import java.util.*;
import Utils.*;

public class CombinationSum39 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		CombinationSum39 cn = new CombinationSum39();

		System.out.println(cn.combinationSum(new int[] {3,4,7}, 7));

	}
	
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		helper(res, new ArrayList<Integer>(), nums, target, 0);
		
		return res;
  }

	private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int target, int start) {
		if(target < 1){
      if(target == 0)
          res.add(new ArrayList<>(list));
      return;
  }
		
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			helper(res, list, nums, target - nums[i], i);
			list.remove(list.size() - 1);
		}
		
	}
}

