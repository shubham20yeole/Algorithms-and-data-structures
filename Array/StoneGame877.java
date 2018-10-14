//https://leetcode.com/problems/stone-game/description/
package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author shubham.yeole
 * @reference https://leetcode.com/problems/stone-game/description/
 * 
 *            Alex and Lee play a game with piles of stones. There are an even
 *            number of piles arranged in a row, and each pile has a positive
 *            integer number of stones piles[i]. The objective of the game is to
 *            end with the most stones. The total number of stones is odd, so
 *            there are no ties. Alex and Lee take turns, with Alex starting
 *            first. Each turn, a player takes the entire pile of stones from
 *            either the beginning or the end of the row. This continues until
 *            there are no more piles left, at which point the person with the
 *            most stones wins. Assuming Alex and Lee play optimally, return
 *            True if and only if Alex wins the game.
 * 
 * 
 *            Example 1: Input: [5,3,4,5] Output: true Explanation: Alex starts
 *            first, and can only take the first 5 or the last 5. Say he takes
 *            the first 5, so that the row becomes [3, 4, 5]. If Lee takes 3,
 *            then the board is [4, 5], and Alex takes 5 to win with 10 points.
 *            If Lee takes the last 5, then the board is [3, 4], and Alex takes
 *            4 to win with 9 points. This demonstrated that taking the first 5
 *            was a winning move for Alex, so we return true.
 *
 */

public class StoneGame877 {

	public static void main(String[] args) {
		System.out.println(playGame(new Integer[] { 1, 3, 8, 10 }));
	}

	private static boolean playGame(Integer[] is) {

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(is));

		int alexStones = 0, leeStones = 0, size = list.size(), max = 0;
		boolean alexTurn = true;

		for (int i = 0; i < size; i++) {
			max = Math.max(list.get(i), list.get(size - 1));
			if (alexTurn) {
				alexStones = alexStones + max;
				alexTurn = !alexTurn;
			} else {
				leeStones = leeStones + max;
				alexTurn = !alexTurn;
			}

			if (list.get(i) < list.get(size - 1)) {
				list.remove(size - 1);
				size--;
				i--;
			}
		}

		System.out.printf("Alexcount: %s\nLeecount: %s\n", alexStones, leeStones);
		return alexStones > leeStones ? true : false;

	}

}
