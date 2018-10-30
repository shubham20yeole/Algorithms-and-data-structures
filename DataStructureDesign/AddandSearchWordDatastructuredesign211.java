//https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
package DataStructureDesign;

import java.util.Arrays;

class AddandSearchWordDatastructuredesign211 {
	/** Initialize your data structure here. */
	TireNode root;

	public AddandSearchWordDatastructuredesign211() {
		root = new TireNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TireNode head = root;
		for (int i = 0; i < word.length(); i++) {
			int curr = word.charAt(i) - 'a';
			if (head.childrens[curr] == null) {
				head.childrens[curr] = new TireNode();
			}
			head = head.childrens[curr];
		}

		head.isLeafNode = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return search(word, this.root);
	}

	public boolean search(String word, TireNode root) {
		TireNode head = root;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '.') {
				for (int j = 0; j < head.childrens.length; j++) {
					if (head.childrens[j] == null)
						continue;
					if (search(word.substring(i + 1, word.length()), head.childrens[j]))
						return true;
				}
				return false;
			}
			int curr = word.charAt(i) - 'a';
			if (head.childrens[curr] == null) {
				return false;
			}
			head = head.childrens[curr];
		}

		return head.isLeafNode == true;
	}

	class TireNode {
		int MAX_ALPHABETS = 26;
		TireNode[] childrens;
		boolean isLeafNode;

		public TireNode() {
			this.childrens = new TireNode[this.MAX_ALPHABETS];
			Arrays.fill(childrens, null);
			this.isLeafNode = false;
		}
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */