//https://leetcode.com/problems/add-two-numbers-ii/
package List;

import Utils.ListNode;
import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersII445 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int size = 1;

		List<Integer> num1 = new ArrayList<Integer>();
		List<Integer> num2 = new ArrayList<Integer>();
		List<Integer> ans = new ArrayList<Integer>();

		while (l1.next != null) {
			num1.add(l1.val);
			l1 = l1.next;
		}

		while (l2.next != null) {
			num2.add(l2.val);
			l2 = l2.next;
		}
		num1.add(l1.val);
		num2.add(l2.val);

		int size1 = num1.size();
		int size2 = num2.size();
		int rem = 0;
		while (size1 >= 0 || size2 >= 0) {
			int a = size1 - 1 >= 0 ? num1.get(size1 - 1) : 0;
			int b = size2 - 1 >= 0 ? num2.get(size2 - 1) : 0;
			int go = (a + b + rem) % 10;
			rem = (a + b + rem) / 10;
			ans.add(0, go);
			size1--;
			size2--;
		}

		ans.forEach((item) -> System.out.print(item + ", "));

		int start = ans.get(0) == 0 ? 1 : 0;
		ListNode head = new ListNode(ans.get(start));
		ListNode temp = head;
		for (int i = start + 1; i < ans.size(); i++) {
			ListNode nn = new ListNode(ans.get(i));
			temp.next = nn;
			temp = temp.next;
		}

		return head;
	}
}
