//
package zOthers;

import Utils.Utils;

public class WorkDaySnehalInterview {
	static Utils utils = new Utils();
	Utils util = new Utils();

	public static void main(String[] args) {
		WorkDaySnehalInterview cn = new WorkDaySnehalInterview();
		utils.printLine(cn.solution());
	}

	public static String solution(int[][] game) {
		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[0].length; col++) {
				game[row][col] = ++count;
			}
		}
		return null;
	}
}
