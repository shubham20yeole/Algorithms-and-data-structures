//https://leetcode.com/problems/evaluate-division
package Graph;

import Utils.Utils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision399 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		EvaluateDivision399 cn = new EvaluateDivision399();

		// String[][] equations = {{"a", "b"}, {"b", "c"}, {"c", "z"}, {"z", "x"}};
		// double[] values = {2.0, 3.0, 4.0, 5.0};
		// String[][] queries = {{"a", "x"}};

		// String[][] equations = {{"a", "e"}, {"b", "e"}};
		// double[] values = {4.0, 3.0};
		// String[][] queries = {{"a", "b"},{"e", "e"},{"x", "x"}};

		String[][] equations = { { "a", "b" }, { "b", "c" }, { "c", "d" }, { "d", "e" } };
		double[] values = { 3.0, 4.0, 5.0, 6.0 };
		String[][] queries = { { "a", "e" } };

		System.out.println(Arrays.toString(cn.calcEquation(equations, values, queries)));
	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double[] result = new double[queries.length];

		Map<String, Map<String, Double>> pair = new HashMap<String, Map<String, Double>>();

		for (int i = 0; i < equations.length; i++) {
			String start = equations[i][0];
			String end = equations[i][1];

			if (!pair.containsKey(start)) {
				Map<String, Double> hm = new HashMap<String, Double>();
				hm.put(end, values[i]);
				pair.put(start, hm);
			} else {
				// if already contains start, add end if end is not present in it
				Map<String, Double> hm = new HashMap<String, Double>(pair.get(start));
				if (!hm.containsKey(end))
					hm.put(end, values[i]);
				pair.put(start, hm);
			}

			if (!pair.containsKey(end)) {
				Map<String, Double> hm = new HashMap<String, Double>();
				hm.put(start, 1 / values[i]);
				pair.put(end, hm);
			} else {
				// if already contains start, add end if end is not present in it
				Map<String, Double> hm = new HashMap<String, Double>(pair.get(end));
				if (!hm.containsKey(start))
					hm.put(start, 1 / values[i]);
				pair.put(end, hm);
			}
		}

		System.out.println(pair);

		for (int i = 0; i < result.length; i++) {
			String start = queries[i][0];
			String end = queries[i][1];
			result[i] = dfs(start, end, pair, new HashSet<String>());
		}

		return result;
	}

	private double dfs(String start, String end, Map<String, Map<String, Double>> pair, Set<String> set) {

		if (set.contains(start))
			return 0.0;
		if (!pair.containsKey(start) || !pair.containsKey(end))
			return -1;
		if (start.equals(end))
			return 1.0;
		if (pair.containsKey(start) && pair.get(start).containsKey(end)) {
			return pair.get(start).get(end);
		}

		set.add(start);

		Map<String, Double> innerMap = pair.get(start);
		double ans = 0.0;
		for (String key : innerMap.keySet()) {
			double dans = dfs(key, end, pair, set);
			System.out.printf("%s/%s = %s\n", key, end, dans);
			ans = innerMap.get(key) * dans;
			if (ans < 0)
				return -1;
		}

		return ans;
	}
}
