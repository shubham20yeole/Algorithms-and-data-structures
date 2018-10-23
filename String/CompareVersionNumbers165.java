//https://leetcode.com/problems/compare-version-numbers/
package String;

import Utils.Utils;

public class CompareVersionNumbers165 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		CompareVersionNumbers165 cn = new CompareVersionNumbers165();

		utils.printLine(cn.compareVersion("23", "0.1"));

	}

	public int compareVersion(String version1, String version2) {
		String[] ver1 = version1.split("\\."); // [0, 1]
		String[] ver2 = version2.split("\\."); // [1, 1]
		int len = Math.max(ver1.length, ver2.length); // 2
		int index = 0;
		int ans = 0;

		while (index < len) {

			int a = index < ver1.length ? Integer.parseInt(ver1[index]) : 0; // 0
			int b = index < ver2.length ? Integer.parseInt(ver2[index]) : 0; // 1
			index = index + 1;
			if (a == b)
				continue;
			if (a > b)
				return 1;
			else
				return -1;
		}

		return ans;
	}
}
