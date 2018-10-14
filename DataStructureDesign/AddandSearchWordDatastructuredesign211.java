//https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
package DataStructureDesign;

import Utils.Utils;
import java.util.HashSet;
import java.util.Set;

public class AddandSearchWordDatastructuredesign211 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		AddandSearchWordDatastructuredesign211 cn = new AddandSearchWordDatastructuredesign211();
		WordDictionary wordDictionary = new WordDictionary();

		String[] words = { "WordDictionary", "addWord", "addWord", "search", "search", "search", "search", "search",
				"search", "search", "search" };
		String[][] queries = { { "...Word" }, { "ab" }, { "a" }, { "a." }, { "ab" }, { ".a" }, { ".b" }, { "ab." }, { "." },
				{ ".." } };

		for (String word : words)
			wordDictionary.addWord(word);

		for (String[] query : queries)
			System.out.printf("%s - %s\n", query[0], wordDictionary.search(query[0]));

		utils.printLine();

	}
}

class WordDictionary {
	public Set<String> set;

	/** Initialize your data structure here. */
	public WordDictionary() {
		this.set = new HashSet<String>();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		set.add(word);
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		if (this.set.contains(word))
			return true;
		char[] arr = word.toCharArray();
		boolean flag = false;

		for (String w : this.set) {

			if (arr.length != w.length())
				continue;
			for (int i = 0; i < arr.length; i++) {
				char c = arr[i];
				if (c != '.' && w.charAt(i) != c)
					break;
				else
					flag = true;
			}
			if (flag)
				return flag;
		}

		return false;
	}
}