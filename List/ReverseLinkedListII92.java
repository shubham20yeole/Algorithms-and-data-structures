//https://leetcode.com/problems/reverse-linked-list-ii
package List;

import Utils.ListNode;
import Utils.Utils;

public class ReverseLinkedListII92 {

	ListNode head;

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		ReverseLinkedListII92 cn = new ReverseLinkedListII92();

		cn.head = new ListNode(1);
		cn.head.next = new ListNode(2);
		cn.head.next.next = new ListNode(3);
		cn.head.next.next.next = new ListNode(4);
		cn.head.next.next.next.next = new ListNode(5);
		cn.head.next.next.next.next.next = new ListNode(6);
		cn.head.next.next.next.next.next.next = new ListNode(7);
		cn.head.next.next.next.next.next.next.next = new ListNode(8);
		cn.head.next.next.next.next.next.next.next.next = new ListNode(9);
		cn.head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		cn.head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
		utils.printLine();

		cn.transverse(cn.head);
		cn.reverseBetween(cn.head, 4, 1);
		cn.transverse(cn.head);
	}

	private void transverse(ListNode head) {
		ListNode temp = head;

		while (temp.next != null) {
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
		util.printLine();
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode temp = head;
		int s = 1;
		collosion: {
			while (temp.next != null) {

				if (s == m) {
					ListNode first = temp;

					while (m <= n) {

						for (int i = 0; i < n - m; i++) {
							first = first.next;
							System.out.print(first.val + ", ");
						}
						util.printLine();

						int tempVal = temp.val;
						temp.val = first.val;
						first.val = tempVal;
						m++;
						n--;
						first = temp.next;
						temp = temp.next;

					}

					break collosion;
				}
				temp = temp.next;
				s++;
			}
		}
		return head;
	}
}
