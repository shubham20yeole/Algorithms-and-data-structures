//https://leetcode.com/problems/word-search-ii/description/
package Matrix;

import Utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII212 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		// char[][] board = {
		// {'o','a','a','n'},
		// {'e','t','a','e'},
		// {'i','h','k','r'},
		// {'i','f','l','v'}
		// };

		char[][] board = { { 'a', 'b' }, { 'a', 'a' } };
		WordSearchII212 cn = new WordSearchII212();

		// System.out.println(cn.findWords(board, new String[]
		// {"oath","pea","eat","rain", "rain", "rat"}));
		// System.out.println(cn.findWords(board, new String[] {"a"}));
		System.out.println(cn.findWords(board, new String[] { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" }));
		// System.out.println(cn.dfs(board, "aba", 0, 0, 0, new HashSet<String>()));

	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new LinkedList<String>();

		Map<Character, Set<String>> initials = new HashMap<Character, Set<String>>();

		for (String word : words) {
			Character c = word.charAt(0);
			Set<String> t = initials.containsKey(c) ? initials.get(c) : new HashSet<String>();
			t.add(word);
			initials.put(c, t);
		}

		if (initials.isEmpty() || board.length == 0 || board[0].length == 0)
			return res;

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				char c = board[row][col];
				if (initials.containsKey(c)) {
					List<String> w = new ArrayList<String>(initials.get(c));
					for (int i = 0; i < w.size(); i++) {
						String word = w.get(i);
						boolean flag = dfs(board, word, 0, row, col, new HashSet<String>());
						System.out.println(word + " - " + w);

						if (flag) {
							res.add(word);
							w.remove(i);
							if (w.isEmpty()) {
								initials.remove(c);
								break;
							}
						} else
							continue;
					}
				}
			}
		}

		return res;
	}

	public boolean dfs(char[][] board, String word, int i, int row, int col, Set<String> seen) {
		if (!isValid(board, word, i, row, col, seen))
			return false;

		seen.add(row + "-" + col);

		if (board[row][col] == word.charAt(i) && i == word.length() - 1)
			return true;
		if (dfs(board, word, i + 1, row + 1, col, seen))
			return true;
		if (dfs(board, word, i + 1, row - 1, col, seen))
			return true;
		if (dfs(board, word, i + 1, row, col + 1, seen))
			return true;
		if (dfs(board, word, i + 1, row, col - 1, seen))
			return true;

		return false;
	}

	public boolean isValid(char[][] board, String word, int i, int row, int col, Set<String> seen) {
		if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1 || seen.contains(row + "-" + col)
				|| i > word.length() - 1 || board[row][col] != word.charAt(i))
			return false;
		return true;
	}
}
