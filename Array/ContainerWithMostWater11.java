//https://leetcode.com/problems/container-with-most-water/
package Array;

public class ContainerWithMostWater11 {
	public static void main(String[] args) {
		
		ContainerWithMostWater11 className = new ContainerWithMostWater11();
		System.out.println(className.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
	public int maxArea(int[] height) {
	    int maxArea = 0;
	    
	    int start = 0, end = height.length - 1;
	    
	    while (start <= end) {
	    	int sh = height[start];
	    	int eh = height[end];
	    	int areaHeight = Math.min(sh, eh);
	    	maxArea = Math.max(maxArea, areaHeight * (end - start));
	    	if (sh > eh) {
	    		end--;
	    	} else {
	    		start++;
	    	}
	    }
	    
	    return maxArea;
	}
}
