//https://leetcode.com/problems/minimum-time-difference/
package String;

import Utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MinimumTimeDifference539 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		MinimumTimeDifference539 cn = new MinimumTimeDifference539();

		List<String> list = new ArrayList<String>(Arrays.asList(new String[] { "00:00", "23:59", "00:00" }));
		utils.printLine(cn.findMinDifference(list));

	}

	public int findMinDifference(List<String> timeList) {

		List<String> timePoints = new LinkedList<String>(new HashSet<String>(timeList));

		int len = timePoints.size();
		int ans = 24 * 60;
		String time1 = "", time2 = "";
		for (int i = 0; i < len; i++) {
			time1 = timePoints.get(i);
			for (int j = i + 1; j < len; j++) {
				time2 = timePoints.get(j);
				ans = Math.min(ans, getDifference(time1, time2));
			}
		}
		return ans;
	}

	public int getDifference(String time1, String time2) {
		String[] timeArr1 = time1.split(":");
		String[] timeArr2 = time2.split(":");

		int h1 = Integer.parseInt(timeArr1[0]), h2 = Integer.parseInt(timeArr2[0]), m1 = Integer.parseInt(timeArr1[1]),
				m2 = Integer.parseInt(timeArr2[1]), hDiff = 0, mDiff = 0;

		if (h2 == h1) {
			hDiff = 0;
			return Math.abs(m2 - m1);
		} else if (h2 > h1) {
			hDiff = h2 - h1;
			mDiff = m2 - m1;
		} else {
			hDiff = h1 - h2;
			mDiff = m1 - m2;
		}

		int diff = hDiff * 60 + mDiff;

		diff = Math.min(diff, 24 * 60 - diff);

		System.out.println(time1 + " - " + time2 + " | " + diff + " | " + (hDiff * 60 + mDiff) + " | " + hDiff + " | "
				+ mDiff + ", m1: " + m1 + ", m2: " + m2);

		return diff;
	}
}
