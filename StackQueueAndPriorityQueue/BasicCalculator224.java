//https://leetcode.com/problems/basic-calculator/
package StackQueueAndPriorityQueue;

import Utils.Utils;
import java.util.Stack;

public class BasicCalculator224 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		BasicCalculator224 cn = new BasicCalculator224();

		utils.printLine(cn.calculate("(1+(4+5+2)-3)+(6+8)"));
		utils.printLine(cn.calculate("1+1"));

	}

	public int calculate(String eq) {
		Stack<String> s = new Stack<String>();
		char[] arr = eq.toCharArray();
		String num = "";
		String preSign = "#";
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];

			if (Character.isDigit(c)) {
				num = num + c;
				continue;
			}

			if (c == '(' || c == ')' || c == ' ' || c == '+' || c == '-') {
				if (preSign.equals("#") && num != "")
					ans = Integer.parseInt(num);

				if (num != "") {
					if (preSign.equals("+"))
						ans = ans + Integer.parseInt(num);

					if (preSign.equals("-"))
						ans = ans - Integer.parseInt(num);
				}

				if (c == '+' || c == '-') {
					preSign = c + "";
				}
				num = "";
			}
		}

		System.out.println(preSign + " - " + num);
		if (num != "") {
			if (preSign.equals("+"))
				ans = ans + Integer.parseInt(num);

			if (preSign.equals("-"))
				ans = ans - Integer.parseInt(num);
		}
		return ans;
	}
}
