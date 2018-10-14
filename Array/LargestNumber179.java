//https://leetcode.com/problems/largest-number/description/
package Array;

import Utils.Utils;
import java.util.LinkedList;
import java.util.List;

public class LargestNumber179 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		LargestNumber179 cn = new LargestNumber179();

		// int[] nums = {390, 39, 34, 300, 3};
		// int[] nums = {999999998,999999997,999999999};
		int[] nums = { 000, 000, 000 };
		// 390, 39, 34, 300, 3
		// 39 390 34 3 300

		utils.printLine(cn.largestNumber(nums));

	}

	public String largestNumber(int[] nums) {
		String res = "";

		List<String> list = new LinkedList<String>();

		for (int num : nums) {
			list.add(num + "");
		}
		list.sort((String s1, String s2) -> {
			return (s2 + s1).compareTo(s1 + s2);
		});

		System.out.println(list);

		if (list.get(0).equals("0"))
			return "0";

		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {
			res = res + list.get(i);
		}

		return res;
	}
}
