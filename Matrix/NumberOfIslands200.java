package Matrix;

/**
 * 
 * @author shubham.yeole
 * @Reference https://leetcode.com/problems/number-of-islands/description/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * 
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 * 
 */

public class NumberOfIslands200 {
	public static void main(String[] args) {
		int[][] world = new int[][] {
			{1, 1, 1, 1, 0},
			{1, 1, 0, 1, 1},
			{1, 1, 0, 0, 1},
			{0, 0, 0, 1, 0},
			{1, 1, 0, 0, 0}};
			
			System.out.println(numberOfIsLand(world));
			
	}

	private static int numberOfIsLand(int[][] world) {
		int isLandCount = 0;
		
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				if (world[row][col] == 1) {
					dfs(world, row, col);
					isLandCount++;
				}
			}			
		}
		return isLandCount;
	}

	private static void dfs(int[][] world, int row, int col) {
		
		if(col < 0 || row < 0 || col > world[0].length - 1 || row > world.length - 1 || world[row][col] == 0) {
			return;
		}
		
		world[row][col] = 0;
		
		dfs(world, row - 1, col);
		dfs(world, row + 1, col);
		dfs(world, row, col-1);
		dfs(world, row, col+1);

	}
}
