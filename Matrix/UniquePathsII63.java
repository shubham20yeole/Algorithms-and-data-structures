//https://leetcode.com/problems/unique-paths-ii
package Matrix;

public class UniquePathsII63 {

	private int maxRes = 0;

	public static void main(String[] args) {
		int[][] world = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		UniquePathsII63 className = new UniquePathsII63();

		System.out.println(className.uniquePathsWithObstacles(world));

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1 && obstacleGrid[0][0] == 0) {
			return 1;
		}

		if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1 && obstacleGrid[0][0] == 1) {
			return 0;
		}
		dfs(obstacleGrid, 0, 0);
		return maxRes;
	}

	public boolean dfs(int[][] obstacleGrid, int row, int col) {

		if (row < 0 || col < 0 || row > obstacleGrid.length - 1 || col > obstacleGrid[0].length - 1
				|| obstacleGrid[row][col] == 1) {
			return false;
		}

		if (row == obstacleGrid.length - 1 && col == obstacleGrid[row].length - 1)
			return true;

		boolean down = dfs(obstacleGrid, row + 1, col);
		boolean right = dfs(obstacleGrid, row, col + 1);

		if (down)
			maxRes++;
		if (right)
			maxRes++;
		return false;
	}
}
