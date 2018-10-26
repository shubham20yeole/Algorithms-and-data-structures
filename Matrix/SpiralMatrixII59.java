//https://leetcode.com/problems/spiral-matrix-ii/
package Matrix;

import Utils.Utils;

public class SpiralMatrixII59 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		SpiralMatrixII59 cn = new SpiralMatrixII59();

		utils.printMatrix(cn.generateMatrix(10));

	}

	public int[][] generateMatrix(int n) {
		int[][] mat = new int[n][n];
		if (n == 0)
			return mat;
		int row = 0, col = 0;
		mat[row][col] = 1;
		for (int i = 2; i <= n * n; i++) {
			int[] ans = getRowCol(mat, row, col);
			row = ans[0];
			col = ans[1];
			mat[row][col] = i;

		}
		return mat;
	}

	public int[] getRowCol(int[][] mat, int r, int c) {
		// if right and down || only right available space move right
		boolean up, down, right, left;
		right = c + 1 <= mat[0].length - 1 && mat[r][c + 1] == 0;
		left = c - 1 >= 0 && mat[r][c - 1] == 0;
		up = r - 1 >= 0 && mat[r - 1][c] == 0;
		down = r + 1 <= mat.length - 1 && mat[r + 1][c] == 0;

		if (!up && !left && (right && down || right))
			c = c + 1;
		if (!right && !up && (left && down || down))
			r = r + 1;
		if (!right && !down && (left && up || left))
			c = c - 1;
		if (!left && !down && (up && right || up))
			r = r - 1;

		return new int[] { r, c };
	}
}
