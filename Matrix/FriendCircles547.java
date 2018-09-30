//https://leetcode.com/problems/friend-circles
package Matrix;
import Utils.*;

public class FriendCircles547 {
	public static void main(String[] args) {
		int[][] classes = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		
		FriendCircles547 clas = new FriendCircles547();
		Utils utils = new Utils();
		utils.printMatrix(classes);
		System.out.println(clas.findCircleNum(classes));
	}
	
	public int findCircleNum(int[][] world) {
        int isLandCount = 0;
		
        for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				if (world[row][col] == 1) {
					world[col][row] = 1;
				}
			}			
		}
        
		Utils utils = new Utils();
		utils.printMatrix(world);

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
    
    private void dfs(int[][] world, int row, int col) {
		
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
