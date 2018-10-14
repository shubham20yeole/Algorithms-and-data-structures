//https://leetcode.com/problems/set-matrix-zeroes/description/
package Matrix;

import Utils.Utils;

public class SetMatrixZeroes73 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		SetMatrixZeroes73 cn = new SetMatrixZeroes73();

		// int matrix[][] = { { 0, 1, 2, 8 }, { 3, 4, 0, 2 }, { 1, 3, 1, 5 } };
		int matrix[][] = { { 1, 0, 1 } };
		// int matrix[][] = { { 1, 2, 1 }, { 0, 8, 1 } };
		utils.printMatrix(matrix);
		utils.printLine();
		cn.setZeroes(matrix);
		utils.printLine();
		utils.printMatrix(matrix);
	}

	public void setZeroes(int[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0)
			return;

		boolean isCol = matrix[0][0] == 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int cur = matrix[i][j];
				if (cur == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		int[] col = matrix[0];

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0)
				matrix[0][i] = 0;
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0)
				matrix[i][0] = 0;
		}

		// See if the first row needs to be set to zero as well
		if (isCol) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}

			for (int j = 0; j < matrix.length; j++) {
				matrix[j][0] = 0;
			}
		}
	}
}
