//https://leetcode.com/problems/remove-k-digits
package LeetCode;

import java.util.*;

/**
 * @author shubham.yeole
 * @reference https://leetcode.com/problems/remove-k-digits/description/
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * 
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 */
public class RemoveKDigits402 {
	
	public static void main(String[] args) {
		System.out.println(minifiedNumber("5472219", 3)); // 2219
		System.out.println(minifiedNumber("1432219", 3)); // 1219
		System.out.println(minifiedNumber("10200", 1)); // 200
		System.out.println(minifiedNumber("10", 2)); // 0
	}


	private static String minifiedNumber(String string, int k) {
		
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < string.length(); i++) {
			list.add(string.charAt(i));
		}
		
		int max = Character.getNumericValue(list.get(0)),
				maxIndex = 0;
		
		for (int i = 1; i < list.size(); i++) {
			
			if(k == 0) break;
			
			int cur = Character.getNumericValue(list.get(i));
			
			if (cur > max) {
				maxIndex = i;
				max = cur;
			}
			
			
			list.remove(maxIndex);
			k--;
		}
		
		
		return Arrays.toString(list.toArray());
	}
	
}


// 2432219
// 2219

//
//min 2  
//for 
//		min < str[i]
//				i++;
//		k--
//else min = str[i]
//		print min
