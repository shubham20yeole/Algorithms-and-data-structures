package LeetCode;

import java.util.Arrays;

/**
 * 
 * @author shubham.yeole
 * 
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * 
 * Input: [1,2,0]
 * Output: 3
 * 
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 */

public class FirstMissingPositive41 {
	
	public static void main(String[] args) {
		
		int[] input = new int[] {1,2,0};
		int[] input2 = new int[] {3,4,-1,1};
		int[] input3 = new int[] {7,8,9,11,12};
				
		System.out.printf("Array: %s\nAnswer: %s\n\n", Arrays.toString(input), findFirstMissingNumber(input));
		System.out.printf("Array: %s\nAnswer: %s\n\n", Arrays.toString(input2), findFirstMissingNumber(input2));
		System.out.printf("Array: %s\nAnswer: %s\n\n", Arrays.toString(input3), findFirstMissingNumber(input3));
	}

	private static int findFirstMissingNumber(int[] input) {

		int min = input[0],
				max = input[0];

		for (int i = 1; i < input.length; i++) {
			int c = input[i];
			
			if (c <= 0 ) continue;
			
			min = Math.min(min, c);
			max = Math.max(max, c);
		}
		
		
		if (min == 1) {
			return max + 1;
		}
		
		return 1;
	}
	
}
