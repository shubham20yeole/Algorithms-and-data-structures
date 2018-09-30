//https://leetcode.com/problems/add-two-numbers
package List;

import java.util.*;

/**
 * @author shubham.yeole
 * @reference https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */

public class AddTwoNumbers2 {
	public static void main(String[] args) {
		
		List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(new Integer[] {2, 4, 3}));
		
		List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(new Integer[] { 6, 4}));
		
		AddTwoNumbers2 className = new AddTwoNumbers2();
		
		System.out.println(className.addTwoNumbers(l1, l2));
		
	}
	
	public List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
		List<Integer> result = new LinkedList<Integer>();
		
		int maxLength = Math.max(l1.size(), l2.size()) - 1;
		int rem = 0;

		while(maxLength >= 0) {
			int a = l1.get(maxLength) != null ? l1.get(maxLength) : 0;
			int b = l2.get(maxLength) != null ? l2.get(maxLength) : 0;
			int sum = a + b + rem;
			if (sum > 9) {
				result.add(sum % 10);
				rem = sum/10;
			} else {
				result.add(sum);
			}
			
			
			maxLength--;
		}
		
		Collections.reverse(result);
		
        return result;
    }
}
