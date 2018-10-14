package String;

import Utils.Utils;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	String ans = "";
	int minLength = Integer.MAX_VALUE;

	public static void main(String[] args) {

		MinimumWindowSubstring76 cn = new MinimumWindowSubstring76();

		String s = "aa";
		String t = "aa";
		utils.printLine(cn.minWindow(s, t));
	}

	public String minWindow(String s, String t) {
		String res = "";

		if (s.length() == 0 || t.length() == 0 || t.length() > s.length())
			return res;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			Character c = t.charAt(i);
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}

		return minWindow(s, t, map);
	}

	public String minWindow(String s, String t, Map<Character, Integer> map) {
		String res = "";
		int start = -1, end = -1;

		Map<Character, Integer> map2 = new HashMap<Character, Integer>(map);

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (map.containsKey(c)) {

				if (start == -1)
					start = i;
				if (start != -1)
					end = i;

				// System.out.println(map + "\n" + map2 + "\n" + c + "\n\n");

				if (map2.containsKey(c)) {
					if (map2.get(c) == 1)
						map2.remove(c);
					else
						map2.put(c, map2.get(c) - 1);
				}

				if (map2.isEmpty())
					break;

				minWindow(s.substring(i + 1), t, map);

			}
		}

		if (!map2.isEmpty())
			return res;

		System.out.println(start + " - " + end);

		if (end - start < minLength) {
			minLength = end - start;
			ans = s.substring(start, end + 1);
			return ans;
		}

		return ans;
	}
}
