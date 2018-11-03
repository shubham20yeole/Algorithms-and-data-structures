//https://leetcode.com/problems/longest-valid-parentheses/
package StackQueueAndPriorityQueue;

import Utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class LongestValidParenthesis32 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		LongestValidParenthesis32 cn = new LongestValidParenthesis32();

		utils.printLine(cn.longestValidParentheses("(("));

	}

	public int longestValidParentheses(String s) {
		int max = 0, len = s.length(), subAns = 1;
		char curr;
		if (len <= 1)
			return max;

		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> indexes = new TreeSet<Integer>();
		// (
		for (int i = 0; i < len; i++) {
			curr = s.charAt(i);
			if (curr == '(') {
				stack.push(i);
				continue;
			}

			if (stack.isEmpty())
				continue;

			indexes.add(i);
			indexes.add(stack.pop());
		}

		System.out.println(indexes);
		if (indexes.size() == 0)
			return 0;
		List<Integer> list = new ArrayList<Integer>(indexes);
		int prev = list.get(0), present;
		for (int i = 1; i < list.size(); i++) {
			present = list.get(i);
			if (present == prev + 1)
				subAns++;
			else {
				subAns = 1;
			}
			prev = present;
			max = Math.max(max, subAns);
		}
		return max;
	}

}
