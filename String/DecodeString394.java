//https://leetcode.com/problems/decode-string
package String;

import Utils.Utils;
import java.util.Stack;

public class DecodeString394 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		DecodeString394 cn = new DecodeString394();

		String s = "3[abc4[zx]#]2[ab]";
		utils.printLine(cn.decodeString3(s, 0));
		utils.printLine(cn.decodeString(s));

	}

	private String decodeString3(String s, int last) { // 3[abc]

		System.out.println(s + "\n\n\n");
		String time = "";
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				time = time + c;
			else {
				start = i + 1;
				break;
			}
		}

		int times = Integer.parseInt(time);
		String res = "";
		char p = ' ', c = ' ';
		while (times != 0) {
			for (int i = start; i < s.length(); i++) {
				c = s.charAt(i);
				p = c;

				last++;

				if (Character.isDigit(c)) {
					res = res + decodeString3(s.substring(i), last);
					break;
				}

				if (c == ']')
					break;
				else
					res = res + s.charAt(i);
			}
			times--;
		}

		if (c == ']' && last + 1 < s.length() && Character.isDigit(s.charAt(last + 1)))
			res = res + decodeString3(s.substring(last + 1, s.length()), last);
		System.out.println(" - " + res + " - " + p + " - " + c + " - " + last);

		return res;
	}

	public String decodeString(String s) {
		if (s == null || s.isEmpty())
			return s;
		int count = 0;
		StringBuilder cursb = new StringBuilder();
		Stack<Integer> si = new Stack<>(); //
		Stack<String> ss = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '[') {
				ss.push(cursb.toString());
				si.push(count);
				cursb = new StringBuilder();
				count = 0;
			} else if (c == ']') {
				count = si.pop();
				if (count > 0) {
					StringBuilder prevsb = new StringBuilder(ss.pop());
					for (int i = 0; i < count; i++) {
						prevsb.append(cursb);
					}
					cursb = prevsb;
				}
				count = 0;
			} else if (Character.isDigit(c)) {
				count *= 10;
				count += c - '0';
			} else {
				cursb.append(c);
			}
		}
		return cursb.toString();
	}

}
