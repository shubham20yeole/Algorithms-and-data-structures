//https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
package String;

import java.util.*;
import Utils.*;

public class SubstringwithConcatenationofAllWords30 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		SubstringwithConcatenationofAllWords30 cn = new SubstringwithConcatenationofAllWords30();

		System.out.println(cn.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out.println(cn.findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","word" }));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new LinkedList<Integer>();
		
		if(s.length() == 0 || words.length == 0) return res;
		
		int strSize = words[0].length();
		
		HashMap<String, Integer> om = new HashMap<String, Integer>();

		for (int i = 0; i < words.length; i++) {
			String curr = words[i];

			if(curr.length() != strSize) return res;
			om.put(curr, om.containsKey(curr) ? om.get(curr) + 1: 1);
			
		}
		
		
		

		for (int i = 0; i < s.length(); i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>(om);

			for (int j = i + strSize; j <= s.length(); j = j + strSize) {
				
				String curr = s.substring(j-strSize, j);

				if(!map.containsKey(curr)) break;

				
				if(map.containsKey(curr)) {
					if(map.get(curr) == 1) map.remove(curr);
					else map.put(curr, map.get(curr) -1);
				}
				if(map.isEmpty()) res.add(i);
			}
		}

		return res;
	}
}
