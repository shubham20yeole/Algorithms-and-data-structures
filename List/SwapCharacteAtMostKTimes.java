package List;

import java.util.*;

/**
 * 
 * @author shubham.yeole
 * 
	Given two string s and t and a positive integer K, determine whether we can swap any two characters in string s at most K times so that s is equal to t.
	
	Example 1
	
	s = "converse"
	t = "conserve"
	K = 1
	return true because we can swap v and s in string s and we swap only once which is not greater than K times.
	
	Example 2
	
	s = "aabbccdd"
	t = "ddbbccaa"
	K = 3
	return true because string s can be converted to string t in two swaps which is not greater than K. But in example 2, if string s and string t are still the same but K becomes 1, then we should return false.
	
	The length of string s and t are guaranteed to be the same.
 *
 */

public class SwapCharacteAtMostKTimes {
	public static void main(String[] args) {
		
		List<Character> list1 = new ArrayList<Character>(Arrays.asList(new Character[] {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'b'}));
		List<Character> list2 = new ArrayList<Character>(Arrays.asList(new Character[] {'d', 'c', 'b', 'b', 'c', 'c', 'a', 'b', 'a', 'd'}));
		
		System.out.println(swapCharacteAtMostKTimes(list1, list2));
	}

	private static boolean swapCharacteAtMostKTimes(List<Character> list1, List<Character> list2) {
		
		int size = list1.size();
		
		for (int i = 0; i < size; i++) {
			char cs = list1.get(i),
				ts = list2.get(i);
			
			if(cs != ts) {
				int ni = findSwapIndex(cs, ts, list1, list2);
				if(ni == -1) return false;
				
				Character temp = list1.get(i);
				list1.set(i, list1.get(ni));
				list1.set(ni, temp);
				
			}
		}
		
		return list1.equals(list2);
	}
	
	private static int findSwapIndex(char c1, char c2, List<Character> list1, List<Character> list2) {
		int size = list1.size();
		
		for (int i = 0; i < size; i++) {
			if (list1.get(i) == c2 && list2.get(i) == c1) return i;
		}
		
		return -1;
	}
}
