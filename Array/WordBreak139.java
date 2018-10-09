//https://leetcode.com/problems/word-break
package Array;

import java.util.*;

public class WordBreak139 {
	public static void main(String[] args) {
		WordBreak139 cn = new WordBreak139();

		// System.out.println(cn.wordBreak("leetcode", new
		// LinkedList<String>(Arrays.asList(new String[] {"leet", "co", "leetc",
		// "ode"}))));
		System.out
				.println(cn.wordBreak("abcd", new LinkedList<String>(Arrays.asList(new String[] { "a", "abc", "b", "cd" }))));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>(wordDict);

		return wordBreak(s, set);
	}

	private boolean wordBreak(String s, Set<String> set) {
		if (set.contains(s))
			return true;

		String temp = "";
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			temp = temp + c;
			if (set.contains(temp)) {
				flag = wordBreak(s.substring(i + 1, s.length()), set);
				if (flag)
					break;
			}
		}

		return flag;
	}
}
