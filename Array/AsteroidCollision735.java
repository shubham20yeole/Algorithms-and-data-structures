//https://leetcode.com/problems/asteroid-collision/
package Array;

import java.util.Arrays;
import java.util.*;

public class AsteroidCollision735 {
	public static void main(String[] args) {

		AsteroidCollision735 as = new AsteroidCollision735();
		
		System.out.println(Arrays.toString(as.asteroidCollision(new int[] { -2, -2, 1, -2 })));
		System.out.println(Arrays.toString(as.asteroidCollision(new int[] { 5, 10, -5, -5 })));
		System.out.println(Arrays.toString(as.asteroidCollision(new int[] { 5, -5 })));
		System.out.println(Arrays.toString(as.asteroidCollision(new int[] { 10, 2, -5 })));
	}
	
	public int[] asteroidCollision(int[] as) {
		
		int count = 0;

		
		Stack<Integer> stack = new Stack<Integer>(); 

		for (int ni : as) {
			collision: {
			
				while(!stack.isEmpty() && ni < 0 && stack.peek() > 0) {
					if (stack.peek() == -ni) {
						stack.pop();
						break collision;
					}
					
					if (stack.peek() > -ni) {
						break collision;
					} else {
						stack.pop();
						continue;
					}
				}
				
				stack.push(ni);
			}
			
		}
		
		int[] res = new int[stack.size()];

		while (!stack.isEmpty()) {
			res[count++] = stack.pop();
		}
		
		for(int i = 0; i < res.length / 2; i++)
		{
		    int temp = res[i];
		    res[i] = res[res.length - i - 1];
		    res[res.length - i - 1] = temp;
		}
		
		return res;
    }
}
