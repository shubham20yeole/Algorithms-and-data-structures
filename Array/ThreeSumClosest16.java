//https://leetcode.com/problems/3sum-closest
package Array;

public class ThreeSumClosest16 {
	public static void main(String[] args) {
		ThreeSumClosest16 cn = new ThreeSumClosest16();

	}

	public int threeSumClosest(int[] nums, int target) {

		int fir, sec, cs = nums[0] + nums[1] + nums[2], diff = target - cs;

		for (int thi = 2; thi < nums.length; thi++) {
			fir = nums[thi - 2];
			sec = nums[thi - 1];
			for (int in = thi; in < nums.length; in++) {
				diff = cs - fir + sec + nums[in];
			}
		}
		return cs;
	}
}
