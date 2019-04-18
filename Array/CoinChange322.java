//https://leetcode.com/problems/coin-change
package Array;

import Utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange322 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		CoinChange322 cn = new CoinChange322();

		// int[] coins = { 1, 2, 5 };
		// int amount = 11;

		int[] coins = { 186, 419, 83, 408 };
		int amount = 6249;
		System.out.println(cn.coinChange(coins, amount));

	}

	public int coinChange(int[] coins, int amount) {

		if (amount == 0)
			return 0;

		if (coins.length == 0)
			return -1;

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, 0);
		Arrays.sort(coins);
		int curr;
		Set<Integer> coinsSet = new HashSet<Integer>();

		for (Integer coin : coins) {
			coinsSet.add(coin);
		}

		dp[1] = coinsSet.contains(1) ? 1 : 0;

		for (int i = 1; i < dp.length; i++) {
			curr = dp[i];
			if (coinsSet.contains(i)) {
				dp[i] = 1;
				continue;
			}
			dp[i] = i;
			for (int k = 0; k < coins.length; k++) {
				if (dp[coins[k]] > 0 && dp[i - coins[k]] > 0) {
					dp[i] = Math.min(dp[coins[k]] + dp[i - coins[k]], dp[i]);
					// System.out.println(i + " = " + dp[coins[k]] * coins[k] + dp[i - coins[k]] *
					// (i - coins[k]));
				}
			}

			if (dp[i] == i && !coinsSet.contains(1))
				dp[i] = 0;
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.println(i + " - " + dp[i]);
		}
		return dp[dp.length - 1] == 0 ? -1 : dp[dp.length - 1];
	}

	public int coinChange2(int[] coins, int amount) {

		if (coins.length == 0 || amount == 0)
			return 0;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		coinChange(coins, 0, amount, new ArrayList<Integer>(), res);

		int minCoins = Integer.MAX_VALUE;

		for (int i = 0; i < res.size(); i++) {
			minCoins = Math.min(minCoins, res.get(i).size());
		}

		System.out.println(res);

		return minCoins;
	}

	public void coinChange(int[] coins, int start, int amount, List<Integer> list, List<List<Integer>> res) {

		if (amount < 1) {
			if (amount == 0) {
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = start; i < coins.length; i++) {
			list.add(coins[i]);
			coinChange(coins, i, amount - coins[i], list, res);
			list.remove(list.size() - 1);
		}

	}
}
