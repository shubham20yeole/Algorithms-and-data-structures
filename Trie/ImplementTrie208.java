//https://leetcode.com/problems/implement-trie-prefix-tree/
package Trie;

import java.util.Arrays;

/* 
 * TrieNode
 * 			Variables: Max_ALPHABETS, TrieNode Array, isLeafNode
 * 		TrieNode constructor
 * 			isLeafNode: false
 * 			Array.fill null
 * 			
 * */

public class ImplementTrie208 {

	TrieNode root;

	/** Initialize your data structure here. */
	public ImplementTrie208() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {

		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (temp.childrens[c] == null) {
				temp.childrens[c] = new TrieNode();
			}

			temp = temp.childrens[c];
		}

		temp.isLeafNode = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode temp = root;
		int c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i) - 'a';
			if (temp.childrens[c] == null)
				return false;

			temp = temp.childrens[c];
		}

		return temp != null && temp.isLeafNode;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String word) {
		TrieNode temp = root;
		int c;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i) - 'a';
			if (temp.childrens[c] == null)
				return false;

			temp = temp.childrens[c];
		}

		return true;
	}

	class TrieNode {
		int MAX_ALPHABET = 26;
		TrieNode[] childrens;
		boolean isLeafNode;

		public TrieNode() {
			this.isLeafNode = false;
			this.childrens = new TrieNode[this.MAX_ALPHABET];
			Arrays.fill(this.childrens, null);
		}
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */