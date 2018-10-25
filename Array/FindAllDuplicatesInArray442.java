//https://leetcode.com/problems/find-all-duplicates-in-an-array/
package Array;

import Utils.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInArray442 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		FindAllDuplicatesInArray442 cn = new FindAllDuplicatesInArray442();

		cn.findDuplicates(new int[] { 4, 3, 2, 7, 0, 0, 8, 2, 3, 1 });

	}

	public List<Integer> findDuplicates(int[] nums) {
		Set<Integer> rep = new HashSet<Integer>();
		boolean zeroFlag = false;
		for (int i = 0; i < nums.length; i++) {
			int curr = Math.abs(nums[i]);
			if (curr == 0 && !zeroFlag) {
				zeroFlag = true;
				continue;
			}
			if (curr == 0 && zeroFlag) {
				rep.add(0);
				continue;
			}
			if (curr != 0 && nums[curr - 1] < 0) {
				rep.add(curr);
			}

			nums[curr - 1] = -Math.abs(nums[curr - 1]);

		}

		return new ArrayList<Integer>(rep);
	}
}
