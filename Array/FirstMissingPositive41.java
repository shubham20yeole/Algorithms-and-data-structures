//https://leetcode.com/problems/first-missing-positive/
package Array;

import Utils.Utils;
import java.util.Arrays;

public class FirstMissingPositive41 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		FirstMissingPositive41 cn = new FirstMissingPositive41();

		// utils.printLine(cn.firstMissingPositive(new int[] { 1, 2, 3 }));
		// utils.printLine(cn.firstMissingPositive(new int[] { 1, 1000 }));
		// utils.printLine(cn.firstMissingPositive(new int[] { 11, 3, 9, 1, 2, 8, 7, 5,
		// 4, 6 }));
		utils.printLine(cn.firstMissingPositive(new int[] { 3, 4, -1, 1 }));

	}

	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 1;
		else if (len == 1 && nums[0] != 1)
			return 1;

		for (int i = 0; i < len; i++) {
			int curr = nums[i];
			int temp = 0;

			while (curr != 0 && curr >= 0 && curr <= len && curr != nums[curr - 1]) {
				temp = nums[curr - 1];
				nums[curr - 1] = curr;
				curr = temp;
			}
		}

		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < len; i++) {
			int curr = nums[i];
			if (curr != i + 1)
				return i + 1;
		}
		return len + 1;
	}
}
