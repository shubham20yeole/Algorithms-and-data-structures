//https://leetcode.com/problems/first-missing-positive/
package Array;
import java.util.*;
import Utils.*;

public class FirstMissingPositive41 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		FirstMissingPositive41 cn = new FirstMissingPositive41();

		utils.printLine(cn.firstMissingPositive(new int[] {31,12,0,11}));

	}
	
	public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        if (nums[i] < 0 || nums[i] > n) {
            nums[i] = 0;
        }
    }

    for (int num : nums) {
        if (num != 0) {
            int index = Math.abs(num) - 1;
            if (nums[index] == 0) {
                nums[index] = -(index + 1);
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }
    }
    
    System.out.println(Arrays.toString(nums));

    for (int i = 0; i < n; i++) {
        if (nums[i] >= 0) {
            return i + 1;
        }
    }
    return n + 1;
}
}

