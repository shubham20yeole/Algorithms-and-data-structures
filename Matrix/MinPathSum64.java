//https://leetcode.com/problems/minimum-path-sum/
package Matrix;

import Utils.Utils;

public class MinPathSum64 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		MinPathSum64 cn = new MinPathSum64();

		utils.printLine(cn.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));

	}

	public int minPathSum(int[][] grid) {

		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int rows = grid.length, cols = grid[0].length, curr;

		boolean up, left;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				curr = grid[row][col];
				up = row - 1 >= 0;
				left = col - 1 >= 0;
				if (!up && !left)
					continue;
				if (!up && left) {
					grid[row][col] = grid[row][col - 1] + curr;
					continue;
				}

				if (up && !left) {
					grid[row][col] = grid[row - 1][col] + curr;
					continue;
				}

				if (up && left) {
					grid[row][col] = Math.min(grid[row][col - 1], grid[row - 1][col]) + curr;
					continue;
				}
			}
		}

		return grid[rows - 1][cols - 1];
	}
}
