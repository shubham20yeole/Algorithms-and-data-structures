package List;

import java.util.*;

/**
 * 
 * @author shubham.yeole
 * 
 * // move a joker 1 step ahead
 * 1 2 3 4 5 a b
 * 1 2 3 4 5 b a
 * 
 * move b joker 2 step ahead
 * 1 2 3 4 5 b a
 * 1 b 2 3 4 5 a
 * 
 *  triple cut
 *  1 2 b 3 4 a 5
 *  5 b 3 4 a 1 2
 *  
 *  count cut
 *  5 b 3 4 a 1 2 
 *  3 4 a 1 5 b 2
 *
 */
public class DeckCardsRotate {
	public static void main(String[] args) {
//		moveAJocker
//		ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(new Object[] {1, 2, 3, 4, 5, 6, 'a', 'b', 7, 8}));
		ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(new Object[] {1, 2, 3, 4, 5, 6, 'b', 7, 'a'}));
		
//		ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(new Object[] {1, 2, 3, 4, 5, 6, 'a', 7, 8, 'b', 9, 10}));

		
		printList(list, "TESTING");
		
		moveAJocker(list);
		tripleCut(list);
		
	}


	private static void tripleCut(ArrayList<Object> list) {
		int aIndex = list.indexOf('a');
		int bIndex = list.indexOf('b');
		
		int min = Math.min(aIndex, bIndex);
		int max = Math.max(aIndex, bIndex);
		
		
		List<Object> result = new ArrayList<Object>();
		result.addAll(list.subList(max+1, list.size()));
		result.addAll(list.subList(min, max+1));
		result.addAll(list.subList(0, min));
		printList(result, "tripleCut");

		
	}

	private static void moveAJocker(ArrayList<Object> list) {
		
		int aIndex = list.indexOf('a');
		if (aIndex == list.size() - 1) {
			List<Object> result = new ArrayList<Object>();
			result.add('a');
			result.addAll(list.subList(0, aIndex));
			printList(result, "moveAJocker-lastIndex");
			return;
		}
		
		Object temp = list.get(aIndex);
		list.set(aIndex, list.get(aIndex+1));
		list.set(aIndex + 1, temp);
		printList(list, "moveAJocker-middleIndex");
	}

	private static void printList(List<Object> list, String method) {
		System.out.println(method + ": \n" + Arrays.toString(list.toArray()));
	}
	

}
