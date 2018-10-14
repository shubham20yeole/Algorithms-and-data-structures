//https://leetcode.com/problems/next-closest-time/
package String;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class NextClosestTime681 {
	public static void main(String[] args) {
		NextClosestTime681 someClass = new NextClosestTime681();
		System.out.println(someClass.nextClosestTime("10:59"));
		System.out.println(someClass.nextClosestTime("23:59"));
		System.out.println(someClass.nextClosestTime("01:32"));
		System.out.println(someClass.nextClosestTime("22:23"));
		System.out.println(someClass.nextClosestTime("23:59"));
		System.out.println(someClass.nextClosestTime("20:56"));
	}

	public String nextClosestTime(String time) {

		if (time.length() == 0 || time.length() > 5 || time.length() < 3)
			return "";

		String[] split = time.split(":", 2);
		String hrs = split[0];
		String min = split[1];

		Set<Integer> set = new TreeSet<Integer>();

		for (Character c : hrs.concat(min).toCharArray()) {
			set.add(Character.getNumericValue(c));
		}

		String newMin = getNextMinNumber(min, set, 59);
		String newHrs = hrs;
		if (newMin.split("-").length > 1) {
			newMin = newMin.split("-")[0];
			newHrs = getNextMinNumber(hrs, set, 24).split("-")[0];

			if (Integer.parseInt(newHrs) > 24) {
				Iterator<Integer> it2 = set.iterator();
				Integer mi = it2.next();
				newHrs = mi.toString().concat(mi.toString());

			}
		}

		return newHrs.concat(":").concat(newMin);
	}

	private String getNextMinNumber(String time, Set<Integer> set, int max) {
		int last = Character.getNumericValue(time.charAt(1));
		int first = Character.getNumericValue(time.charAt(0));
		String res = "";
		Iterator<Integer> it2 = set.iterator();

		Integer min = it2.next();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer temp = it.next();
			if (temp > last) {
				res = first + temp.toString();
				if (Integer.parseInt(res) > max) {
					break;
				}
				return res;
			}
		}

		last = min;

		Iterator<Integer> it3 = set.iterator();
		while (it3.hasNext()) {
			Integer temp = it3.next();
			if (temp > first) {
				res = temp.toString() + last;
				if (Integer.parseInt(res) > max) {
					break;
				}
				return res;
			}
		}

		first = min;
		res = min.toString().concat(min.toString());
		return res + '-' + "true";
	}
}
