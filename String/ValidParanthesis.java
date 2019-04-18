//
package String;

import Utils.Utils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParanthesis {
	static Utils utils = new Utils();
	Utils util = new Utils();
	Set<Character> openings = new HashSet<Character>(Arrays.asList(new Character[] { '[', '(', '{' }));

	public static void main(String[] args) {
		ValidParanthesis cn = new ValidParanthesis();
		System.out.println(cn.isValidParanthesis("{[]}"));
		utils.printLine();
	}

	public boolean isValidParanthesis(String paranthesis) {
		if (paranthesis.length() == 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for (char c : paranthesis.toCharArray()) {
			if (openings.contains(c)) {
				stack.push(c);
				continue;
			}

			if (stack.size() <= 0 || !isMatching(stack.pop(), c))
				return false;

		}
		return true;
	}

	public boolean isMatching(char c, char c2) {
		if (c == '(' && c2 == ')')
			return true;
		if (c == '[' && c2 == ']')
			return true;
		if (c == '{' && c2 == '}')
			return true;

		return false;
	}

}
