//https://leetcode.com/problems/next-permutation
package Array;

import java.util.Arrays;

public class NextPermutation31 {

	public static void main(String[] args) {
		NextPermutation31 nc = new NextPermutation31();

		// int[] input = {1, 1, 5, 2};
		// int[] input = {1, 3, 2}; // 2 1 3
		int[] input = { 2, 3, 1 }; // 3, 1, 2

		nc.nextPermutation(input);

		System.out.println(Arrays.toString(input));
	}

	public void nextPermutation(int[] nums) {

		if (nums.length <= 1)
			return;

		int top = nums[nums.length - 1];
		int topIndex = nums.length - 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (top > nums[i]) {
				nums[topIndex] = nums[i];
				nums[i] = top;
				return;
			} else {
				nums[topIndex] = nums[i];
				nums[i] = top;
				topIndex = i;
				top = nums[i];
			}
		}

		Arrays.sort(nums);
	}
}
