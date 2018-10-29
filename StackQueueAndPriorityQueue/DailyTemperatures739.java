//https://leetcode.com/problems/daily-temperatures/
package StackQueueAndPriorityQueue;

import Utils.Utils;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DailyTemperatures739 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		DailyTemperatures739 cn = new DailyTemperatures739();

		utils.printLine(Arrays.toString(cn.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));

	}

	public int[] dailyTemperatures(int[] T) {
		int prev = T[0];
		int[] ans = new int[T.length];
		Arrays.fill(ans, 0);
		PriorityQueue<Temperature> pq = new PriorityQueue<Temperature>();

		if (T.length <= 1)
			return ans;

		for (int i = 1; i < T.length; i++) {
			int curr = T[i];
			if (!pq.isEmpty() && curr > pq.peek().temp) {
				while (!pq.isEmpty()) {
					Temperature temperature = pq.peek();
					if (temperature.temp < curr) {
						pq.poll();
						ans[temperature.index] = i - temperature.index;
					} else {
						break;
					}
				}
			}

			if (prev < curr) {
				ans[i - 1] = 1;
			} else {
				pq.add(new Temperature(i, curr));
				pq.add(new Temperature(i - 1, prev));
			}

			prev = curr;
		}

		return ans;
	}

	class Temperature implements Comparable {

		int index;
		int temp;

		public Temperature(int index, int temp) {
			this.index = index;
			this.temp = temp;
		}

		@Override
		public int compareTo(Object obj) {
			return this.temp - ((Temperature) obj).temp;
		}
	}
}
