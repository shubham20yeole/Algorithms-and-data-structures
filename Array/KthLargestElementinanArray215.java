//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
package Array;

import Utils.Utils;
import java.util.PriorityQueue;

public class KthLargestElementinanArray215 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		KthLargestElementinanArray215 cn = new KthLargestElementinanArray215();

		int nums[] = { 9, 1, 7, 20, 34, 78, 89, 2 };
		int k = 2;
		utils.printLine(cn.findKthLargest(nums, k));

	}

	public int findKthLargest(int[] nums, int k) {
		if (k > nums.length)
			return -1;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, (i, i2) -> {
			if (i == i2)
				return 0;
			if (i < i2)
				return -1;
			return 1;
		});

		for (int j = 0; j < nums.length; j++) {
			pq.add(nums[j]);
		}

		System.out.println(pq);

		int ans = nums[0];

		for (int j = 1; j < k; j++) {
			if (j == k)
				return pq.poll();
			pq.poll();
		}

		return pq.poll();
	}
}
