//https://leetcode.com/problems/generate-parentheses/
package Array;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

	public static void main(String[] args) {
		GenerateParentheses22 cn = new GenerateParentheses22();
		System.out.println(cn.generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	public void backtrack(List<String> ans, String cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur);
			return;
		}

		if (open < max)
			backtrack(ans, cur + "(", open + 1, close, max);
		if (close < open)
			backtrack(ans, cur + ")", open, close + 1, max);
	}
}
