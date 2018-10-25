//https://leetcode.com/problems/repeated-dna-sequences/
package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences187 {

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> doubleWord = new HashSet<String>();
		Set<String> set = new HashSet<String>();
		int len = s.length();
		for (int i = 0; i <= len - 10; i++) {
			String curr = s.substring(i, i + 10);
			System.out.println(curr);
			if (set.contains(curr))
				doubleWord.add(curr);
			set.add(curr);
		}

		return new ArrayList<String>(doubleWord);
	}
}
