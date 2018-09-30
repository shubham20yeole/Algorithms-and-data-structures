//https://leetcode.com/problems/group-anagrams
package String;
import java.util.*;
import Utils.*;

public class GroupAnagrams49 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		GroupAnagrams49 cn = new GroupAnagrams49();

//		utils.printLine(cn.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}).toString());
		utils.printLine(cn.groupAnagrams(new String[] {"hi", "hi"}).toString());
		
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new LinkedList<List<String>>();
		
		List<String> list = new LinkedList<String>(Arrays.asList(strs));
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			
			List<String> subAns = new LinkedList<String>();

			String target = list.get(i);
			
			if (set.contains(i)) continue;
			else subAns.add(target);

			set.add(i);
			
			for (int j = i + 1; j < list.size(); j++) {
				
				String curr = list.get(j);
				if (!set.contains(j) && isAnagram(target, curr)) {
					subAns.add(curr);
					set.add(j);
				}
			}
			
			ans.add(subAns);
		}
		
		return ans;
    }
	
	public boolean isAnagram(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		if(s1.equals(s2)) return true;
		
		int[] count1 = new int[256];
		int[] count2 = new int[256];
		
		Arrays.fill(count1, 0);
		Arrays.fill(count2, 0);
		
		for (int i = 0; i < s2.length(); i++) {
			count1[s1.charAt(i)] = count1[s1.charAt(i)] + 1;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			count1[s2.charAt(i)] = count1[s2.charAt(i)] - 1;
		}
		
		for (int i = 0; i < count1.length; i++) {
			if(count1[i] != 0) return false;
		}
		
		return true;
	}
}

