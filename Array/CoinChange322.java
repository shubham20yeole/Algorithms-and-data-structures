package Array;
import java.util.*;
import Utils.*;

public class CoinChange322 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		CoinChange322 cn = new CoinChange322();
		
		int[] coins = {1, 2, 5}; int amount = 11;
		
		System.out.println(cn.coinChange(coins, amount));

	}
	
  public int coinChange(int[] coins, int amount) {
  	
  	if(coins.length == 0 || amount == 0) return 0;
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
  	
  	if(amount < 1) {
  		if(amount == 0) {
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

