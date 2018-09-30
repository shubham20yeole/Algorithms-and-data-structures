//https://github.com/shubham20yeole/Java
package zOthers;

/**
 * @author shubham.yeole
 * @reference 
 *
 *
 */
public class GenerateComment {
	
	public static void main(String[] args) {
		String uglyComment = "You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.\n" + 
				"\n" + 
				"You may assume the two numbers do not contain any leading zero, except the number 0 itself.\n" + 
				"\n" + 
				"Example:\n" + 
				"\n" + 
				"Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)\n" + 
				"Output: 7 -> 0 -> 8\n" + 
				"Explanation: 342 + 465 = 807.";
		
		System.out.println(" * " + uglyComment.replace("\n", "\n * "));
	}
	
}
