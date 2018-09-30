//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
package Array;
import java.util.Arrays;

public class FindMinimuminRotatedSortedArray153 {
	int min;
	public static void main(String[] args) {
		
		
		
//		int[] ar = {10,1,10,10,10};
//		int[] ar = { 3, 1};
		int[] ar = { 1, 2, 1};
		
		System.out.println(Arrays.toString(ar));
		
		FindMinimuminRotatedSortedArray153 cn = new FindMinimuminRotatedSortedArray153();
		
		int searchIndex = cn.findMin(ar);
		System.out.printf("ANS: %s",searchIndex);
	}
	
	public int findMin(int[] nums) {
		int end = nums.length - 1;
		
		if(nums.length == 2) return Math.min(nums[0], nums[1]);
		
		if (nums[0] < nums[end]) return nums[0];
		min = nums[end/2];
		getRotatePoint(nums, 0, end, end/2);
	    return min;
	}
	
	
	private int getRotatePoint(int[] ar, int start, int end, int mid) {
		System.out.printf("%s - %s - %s = %s\n", start, mid, end, ar[mid]);

		if (end - start == 1) return mid + 1;
		if (end - start == 0) return mid;
		
		min = Math.min(min, ar[mid]);
		
		if(ar[start] == ar[mid] && ar[mid] == ar[end]) {
			getRotatePoint(ar, start, mid, (start + end)/2);
			getRotatePoint(ar, mid, end, (start + end)/2);
		}

		if(ar[mid - 1] >= ar[mid] && ar[mid] <= ar[mid + 1]) return mid;
				
		if(ar[mid] >= ar[0]) start = mid;
		else end = mid;
	
		mid = getRotatePoint(ar, start, end, (start + end)/2);
	
		return mid;
	}
}
