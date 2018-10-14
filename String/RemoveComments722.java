//https://leetcode.com/problems/remove-comments
package String;

import Utils.Utils;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveComments722 {

	static Utils utils = new Utils();
	Utils util = new Utils();

	public static void main(String[] args) {

		RemoveComments722 cn = new RemoveComments722();
		utils.printLine(cn
				.removeComments(
						new String[] { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
								"/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" })
				.toString());
		utils.printLine(Arrays.toString(new String[] { "int main()", "{ ", "  ", "int a, b, c;", "a = b + c;", "}" }));
	}

	public List<String> removeComments(String[] source) {

		boolean flag = false;
		for (int i = 0; i < source.length; i++) {
			String curr = source[i];

			if (curr.length() == 0)
				continue;

			char p = curr.charAt(0);
			String temp = "" + p;

			for (int j = 1; j < curr.length(); j++) {
				char c = curr.charAt(j);

				if (!flag) {
					if (p == '/' && c == '/') {
						temp = temp.substring(0, temp.length() - 1);
						Util.println(temp);
						break;
					}

					if (p == '/' && c == '*') {
						Util.println(temp);
						flag = true;
						temp = temp.substring(0, temp.length() - 1);
						continue;
					}
					temp = temp + c;
				} else {
					if (p == '*' && c == '/') {
						Util.println(temp);
						flag = false;
					}
				}
				p = c;

			}

			source[i] = temp;
		}

		List<String> res = new LinkedList<String>(Arrays.asList(source));

		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).length() == 0) {
				res.remove(i);
				continue;
			}
		}

		return res;
	}
}
