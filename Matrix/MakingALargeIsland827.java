//https://leetcode.com/problems/making-a-large-island
package Matrix;

public class MakingALargeIsland827 {

	private int count = 0;

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 0, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 1 } };

		MakingALargeIsland827 className = new MakingALargeIsland827();
		System.out.println(className.largestIsland(grid));
	}

	public int largestIsland(int[][] grid) {
		int maxIsland = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 0) {
					grid[row][col] = 1;
					dfs(grid, row, col);
					maxIsland = Math.max(maxIsland, count);
					grid[row][col] = 0;
					count = 0;
				}
			}
		}

		return maxIsland;
	}

	private void dfs(int[][] grid, int row, int col) {

		if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || grid[row][col] == 0) {
			return;
		}

		if (grid[row][col] == 1) {
			grid[row][col] = 0;
			count++;
		}
		;

		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);
	}
}
