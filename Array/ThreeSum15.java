//https://leetcode.com/problems/3sum
package Array;

import java.util.*;

public class ThreeSum15 {
	
	public static void main(String[] args) {
		ThreeSum15 sum = new ThreeSum15();
		
//		List<List<Integer>> res = sum.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
//		List<List<Integer>> res = sum.threeSum(new int[] {0, 0, 0, 0});
		List<List<Integer>> res = sum.threeSum(new int[] {-2, 0, 1, 1, 2});
		
		res.forEach((item) -> {
			System.out.println(Arrays.toString(item.toArray()));
		});
		
	}
	
	public List<List<Integer>> threeSum(int[] nums) {	
		Set<List<Integer>> res = new LinkedHashSet<List<Integer>>();;
		Arrays.sort(nums);
		for (int j = 0; j < nums.length; j++) {
			int first = nums[j];
				for (int i = j + 1; i < nums.length; i++) {
					int sec = nums[i], find = -(first+sec);
					int thirdIndex = Arrays.binarySearch(nums, i + 1, nums.length, find);
					if (thirdIndex > 0) {
						int third = nums[thirdIndex];
						List<Integer> t = new LinkedList<Integer>(Arrays.asList(new Integer[] {first, sec, third}));
						res.add(t);
					}
			}
		}
		
        return new LinkedList<List<Integer>>(res);
    }
}
