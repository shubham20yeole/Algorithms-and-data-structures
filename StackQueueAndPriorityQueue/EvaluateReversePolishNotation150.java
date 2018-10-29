//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
package StackQueueAndPriorityQueue;

import Utils.Utils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation150 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		EvaluateReversePolishNotation150 cn = new EvaluateReversePolishNotation150();

		String[] tokens = { "2" };
		utils.printLine(cn.evalRPN(tokens));

	}

	public int evalRPN(String[] tokens) {
		int ans = 0;
		Stack<String> s = new Stack<String>();
		Set<String> set = new HashSet<String>(Arrays.asList(new String[] { "+", "/", "*", "-" }));
		if (tokens.length == 1 && set.contains(tokens[0]))
			return 0;
		if (tokens.length == 1 && !set.contains(tokens[0]))
			return Integer.parseInt(tokens[0]);

		if (tokens.length < 3 || set.contains(tokens[0]) || set.contains(tokens[1]))
			return ans;
		for (String token : tokens) {
			if (set.contains(token)) {
				int b = Integer.parseInt(s.pop());
				int a = Integer.parseInt(s.pop());
				s.push(getRes(a, b, token));
			} else
				s.push(token);
		}

		return Integer.parseInt(s.pop());
	}

	private String getRes(int a, int b, String t) {
		// TODO Auto-generated method stub
		if (t.equals("+"))
			return (a + b) + "";
		if (t.equals("/"))
			return (a / b) + "";
		if (t.equals("*"))
			return (a * b) + "";
		if (t.equals("-"))
			return (a - b) + "";
		return null;
	}
}
