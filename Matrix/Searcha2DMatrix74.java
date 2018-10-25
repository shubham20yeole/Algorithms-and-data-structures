//https://leetcode.com/problems/search-a-2d-matrix/
package Matrix;

import Utils.Utils;

public class Searcha2DMatrix74 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		Searcha2DMatrix74 cn = new Searcha2DMatrix74();
		int[][] mat = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(cn.searchMatrix(mat, 3));

	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0)
			return false;
		int row = searchRow(matrix, 0, matrix.length - 1, target);
		if (row == -1)
			return false;
		int col = searchCol(matrix[row], 0, matrix[row].length - 1, target);
		if (col == -1)
			return false;
		return matrix[row][col] == target;
	}

	private int searchCol(int[] row, int top, int bottom, int target) {
		if (row.length == 0)
			return -1;

		int mid = (top + bottom) / 2;
		if (bottom - top <= 1) {
			if (target >= row[bottom])
				return bottom;
			else
				return top;
		}

		if (target == row[mid])
			return mid;

		if (target < row[mid])
			return searchCol(row, top, mid, target);

		if (target > row[mid])
			return searchCol(row, mid, bottom, target);

		return -1;
	}

	private int searchRow(int[][] matrix, int top, int bottom, int target) {
		if (matrix.length == 0 || matrix[top].length == 0 || matrix[bottom].length == 0)
			return -1;
		int mid = (top + bottom) / 2;
		if (bottom - top <= 1) {
			if (target >= matrix[bottom][0])
				return bottom;
			else
				return top;
		}

		if (target == matrix[mid][0])
			return mid;

		if (target < matrix[mid][0])
			return searchRow(matrix, top, mid, target);

		if (target > matrix[mid][0])
			return searchRow(matrix, mid, bottom, target);

		return -1;
	}
}
