//https://leetcode.com/problems/merge-k-sorted-lists
package List;

import java.util.*;

public class MergekSortedLists23 {

	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(new Integer[] {1, 4, 5}));
		List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(new Integer[] {6, 7, 8}));
		List<Integer> l3 = new LinkedList<Integer>(Arrays.asList(new Integer[] {2, 6}));
		List<List<Integer>> bulk = new LinkedList<List<Integer>>();
		bulk.add(l1);
		bulk.add(l2);
		bulk.add(l3);
		
		System.out.println(mergeKLists(bulk).toString());
	}
	
	public static List mergeKLists(List<List<Integer>> lists) {
		List<Integer> result = new LinkedList<Integer>();
		result.addAll(lists.get(0));
		
		for (int i = 1; i < lists.size(); i++) {
			List<Integer> tempList = lists.get(i);
			
			for (int j = 0; j < tempList.size(); j++ ) {
				int num = tempList.get(j);
				int min = 0, max = result.size();
				int med = (max - min) / 2;
				
				while(max - min > 1) {
					int medNo = result.get(med);
					
					if (num > medNo) {
						min = med;
						med = min + (max - min)/2;
					} else {
						max = med;
						med = min + (max - min)/2;
					}
				}
				result.add(max, num);
			}
		}
		return result;
    }
}
