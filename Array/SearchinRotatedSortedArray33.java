//https://leetcode.com/problems/search-in-rotated-sorted-array
package Array;

import java.util.Arrays;

public class SearchinRotatedSortedArray33 {
	public static void main(String[] args) {

		int[] ar = { 1, 3 };

		System.out.println(Arrays.toString(ar));

		SearchinRotatedSortedArray33 cn = new SearchinRotatedSortedArray33();

		int searchIndex = cn.search(ar, 3);
		System.out.println(searchIndex);
	}

	public int search(int[] nums, int target) {

		if (nums.length == 0)
			return -1;
		if (nums.length == 1 && nums[0] == target)
			return 0;
		if (nums.length == 1 && nums[0] != target)
			return -1;

		int mid = getRotatePoint(nums, 0, nums.length - 1, (nums.length - 1) / 2);
		// System.out.println(mid + " = " + nums[mid]);
		if (target == nums[mid])
			return mid;

		int start = 0, end = nums.length - 1;

		if (target >= nums[0] && target <= nums[mid - 1]) {
			end = mid;
		} else {
			start = mid;
		}

		return findTarget(nums, target, start, end, (start + end) / 2);
	}

	private int findTarget(int[] nums, int target, int start, int end, int mid) {
		System.out.printf("%s - %s - %s = %s\n", start, mid, end, nums[mid]);

		if (nums[mid] == target)
			return mid;

		if (end - start <= 1 && nums[end] != target)
			return -1;
		if (end - start <= 1 && nums[end] == target)
			return end;

		if (nums[mid] > target)
			end = mid;
		else
			start = mid;

		return findTarget(nums, target, start, end, (start + end) / 2);
	}

	private static int getRotatePoint(int[] ar, int start, int end, int mid) {
		if (end - start == 1)
			return mid + 1;
		if (end - start == 0)
			return mid;
		if (ar[mid - 1] > ar[mid] && ar[mid] < ar[mid + 1])
			return mid;

		if (ar[mid] >= ar[0])
			start = mid;
		else
			end = mid;

		mid = getRotatePoint(ar, start, end, (start + end) / 2);

		return mid;
	}
}
