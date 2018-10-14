//https://leetcode.com/problems/partition-labels/description/
package Array;
import java.util.*;
import Utils.*;

public class PartitionLabels763 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		PartitionLabels763 cn = new PartitionLabels763();

		System.out.println(cn.partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(cn.partitionLabels("aaaaazaaaax"));
	}
	
	public List<Integer> partitionLabels(String S) {
		List<Integer> ans = new LinkedList<Integer>();
		char[] arr = S.toCharArray();	

		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			int end = map.get(c);
			
			for(int j = i + 1; j < end; j++) {
				char c2 = arr[j];
				int end2 = map.get(c2);
				if( end2 > end) end = end2;
			}
			System.out.println(S.substring(i, end + 1));
			ans.add(end + 1 - i);
			i = end;
		}
		
		
		
		System.out.println(map);
		return ans;
  }
	
	public List<Integer> partitionLabelsWrongAnswer(String S) {
		List<Integer> ans = new LinkedList<Integer>();
		
		char[] arr = S.toCharArray();	
		int start = 0, end = 0;
		
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			start = end = i;
			System.out.println(c + " - " + i);
			int index = Arrays.binarySearch(arr, i, arr.length, c);
			if (index > 0) {
				while(true) {
					int s = index + 1, e = arr.length;
					int t = Arrays.binarySearch(arr, s, e, c);
					if (t > 0) index = t;
					else break;
				}
				end = index;
			}
			
			i = end;
		}
		
		return ans;
  }
}

