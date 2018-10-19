//https://leetcode.com/problems/simplify-path/
package String;

import Utils.Utils;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SimplifyPath71 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		SimplifyPath71 cn = new SimplifyPath71();

		utils.printLine("ans: " + cn.simplifyPath("/../a"));

	}

	public String simplifyPath(String path) {
		String[] temp = path.split("/");
		System.out.println(Arrays.toString(temp));

		List<String> list = new LinkedList<String>();

		for (String dir : temp) {
			if (dir.length() != 0)
				list.add(dir);
		}

		if (list.size() == 0)
			return "";
		utils.printList(list);
		String ans = "";
		int back = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			String curr = list.get(i);
			if (back == 0 && !curr.equals("..") && !curr.equals(".")) {
				ans = curr + "/" + ans;
				continue;
			}

			if (!curr.equals("..") && !curr.equals(".") && back > 0)
				back--;

			if (curr.equals(".."))
				back++;
		}

		if (ans.length() <= 1)
			return "/" + ans;
		return "/" + ans.substring(0, ans.length() - 1);
	}

}
