//https://leetcode.com/problems/cheapest-flights-within-k-stops/
package Graph;

import Utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheapestFlightsWithinKStops787 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		CheapestFlightsWithinKStops787 cn = new CheapestFlightsWithinKStops787();
		int[][] flights = { { 3, 4, 7 }, { 6, 2, 2 }, { 0, 2, 7 }, { 0, 1, 2 }, { 1, 7, 8 }, { 4, 5, 2 }, { 0, 3, 2 },
				{ 7, 0, 6 }, { 3, 2, 7 }, { 1, 3, 10 }, { 1, 5, 1 }, { 4, 1, 6 }, { 4, 7, 5 }, { 5, 7, 10 } };

		utils.printLine(cn.findCheapestPrice(8, flights, 4, 3, 7));

	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, Set<Flight>> graph = new HashMap<Integer, Set<Flight>>();
		for (int row = 0; row < flights.length; row++) {
			int s = flights[row][0];
			int d = flights[row][1];
			int c = flights[row][2];
			Set<Flight> flightSet;
			if (graph.containsKey(s)) {
				flightSet = graph.get(s);
			} else {
				flightSet = new HashSet<Flight>();
			}
			flightSet.add(new Flight(d, c));
			graph.put(s, flightSet);
		}

		if (!graph.containsKey(src))
			return -1;

		int ans = findCheapestPrice(graph, src, dst, K, 0);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	public int findCheapestPrice(Map<Integer, Set<Flight>> graph, int src, int dst, int k, int initialCost) {
		int min = Integer.MAX_VALUE;

		if (!graph.containsKey(src)) {
			System.out.println(src);
			return min;
		}

		Set<Flight> lof = new HashSet<Flight>(graph.get(src));
		if (k == 0) {
			for (Flight fli : lof) {
				if (fli.dest == dst) {
					min = Math.min(min, initialCost + fli.cost);
				}
			}
			return min;
		}

		if (lof.size() > 0) {
			for (Flight fli : lof) {
				if (fli.dest == dst) {
					min = Math.min(min, initialCost + fli.cost);
					break;
				}
				min = Math.min(min, initialCost + findCheapestPrice(graph, fli.dest, dst, k - 1, fli.cost));
			}
		}

		return min;
	}

	class Flight {
		int dest, cost;

		public Flight(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		public Flight getFlight() {
			return this;
		}
	}
}