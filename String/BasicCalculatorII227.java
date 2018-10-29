//https://leetcode.com/problems/basic-calculator-ii/
package String;

import Utils.Utils;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BasicCalculatorII227 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		BasicCalculatorII227 cn = new BasicCalculatorII227();

		// utils.printLine(cn.calculate(" 33+5 / 2 * 10"));
		// utils.printLine(cn.calculate("0-2147483647"));
		utils.printLine(cn.calculate("1-1+1"));

	}

	public int calculate(String s) {
		if (s.length() == 0)
			return 0;

		String num = "";

		Set<String> signs = new HashSet<String>();
		signs.add("+");
		signs.add("-");
		signs.add("/");
		signs.add("*");

		char p = s.charAt(0);

		List<String> list = new LinkedList<String>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isWhitespace(c))
				continue;

			if (Character.isDigit(c)) {
				num = num + c;
			}

			if (signs.contains(c + "")) {
				list.add(num);
				list.add(c + "");
				num = "";
			}
		}

		list.add(num);

		Stack<String> addSub = new Stack<String>();

		String pn = list.get(0);
		String ps = list.get(1);

		addSub.push(pn);
		addSub.push(ps);

		for (int i = 2; i < list.size(); i++) {
			String c = list.get(i);

			if (signs.contains(c)) {
				ps = c;
				addSub.push(c);
				continue;
			}

			if (ps.equals("*") || ps.equals("/")) {
				c = "" + eval(addSub.pop(), addSub.pop(), c);
			}

			addSub.push(c);
		}

		List<String> finalList = new LinkedList<String>(addSub);
		pn = finalList.get(0);
		ps = finalList.get(1);
		int ans = Integer.parseInt(pn);
		for (int i = 2; i < finalList.size(); i++) {
			String c = finalList.get(i);

			if (signs.contains(c)) {
				ps = c;
				continue;
			}

			ans = eval(ps, ans + "", c);

		}

		return ans;
	}

	public int eval(String sign, String as, String bs) {
		int a = Integer.parseInt(as);
		int b = Integer.parseInt(bs);

		if (sign.equals("+"))
			return a + b;
		if (sign.equals("-"))
			return a - b;
		if (sign.equals("/"))
			return a / b;
		if (sign.equals("*"))
			return a * b;
		return 0;
	}
}
