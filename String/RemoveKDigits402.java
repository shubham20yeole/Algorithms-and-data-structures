//https://leetcode.com/problems/remove-k-digits
package String;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author shubham.yeole
 * @reference https://leetcode.com/problems/remove-k-digits/description/
 *
 *            Given a non-negative integer num represented as a string, remove k
 *            digits from the number so that the new number is the smallest
 *            possible.
 * 
 *            Note: The length of num is less than 10002 and will be ≥ k. The
 *            given num does not contain any leading zero. Example 1:
 * 
 *            Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove
 *            the three digits 4, 3, and 2 to form the new number 1219 which is
 *            the smallest. Example 2:
 * 
 *            Input: num = "10200", k = 1 Output: "200" Explanation: Remove the
 *            leading 1 and the number is 200. Note that the output must not
 *            contain leading zeroes. Example 3:
 * 
 *            Input: num = "10", k = 2 Output: "0" Explanation: Remove all the
 *            digits from the number and it is left with nothing which is 0.
 *
 */
public class RemoveKDigits402 {

	// Logic behind this question is to iterate through the num string and at any
	// point if you find current number is less than privious number, delete all the
	// numbers greater than curr number prior to current index
	public static void main(String[] args) {

		RemoveKDigits402 className = new RemoveKDigits402();

		System.out.println(className.removeKdigits("5472219", 3)); // 2219
		System.out.println(className.removeKdigits("1432219", 3)); // 1219
		System.out.println(className.removeKdigits("10200", 1)); // 200
		System.out.println(className.removeKdigits("10", 2)); // 0
		System.out.println(className.removeKdigits("1234177711999", 3)); // 0

	}

	public String removeKdigits(String num, int k) {

		if (k >= num.length()) {
			return 0 + "";
		}
		int max = Integer.parseInt(num.charAt(0) + "");

		PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> {
			return b.val - a.val;
		});
		Set<Integer> set = new HashSet<Integer>();
		int lim = k;
		collosion: {
			for (int i = 0; i < num.length(); i++) {
				int curr = Integer.parseInt(num.charAt(i) + "");

				while (!pq.isEmpty()) {
					Element el = pq.poll();
					if (el.val > curr) {
						set.add(el.index);
						lim--;
					} else {
						pq.add(el);
						break;
					}

					if (lim == 0)
						break collosion;
				}

				pq.add(new Element(curr, i));
			}
		}

		if (lim != 0 && lim < num.length()) {
			num = num.substring(0, num.length() - lim);
		}
		System.out.println(set);
		String ans = "";
		for (int i = 0; i < num.length(); i++) {
			if (set.contains(i) || (num.charAt(i) == '0' && ans.length() == 0))
				continue;
			ans = ans + num.charAt(i);
		}
		return ans.length() == 0 ? "0" : ans;
	}

	class Element {
		int val;
		int index;

		public Element(int val, int index) {
			this.val = val;
			this.index = index;
		}

		public Element get() {
			return this;
		}
	}
}