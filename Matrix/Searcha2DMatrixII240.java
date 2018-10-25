//https://leetcode.com/problems/search-a-2d-matrix-ii/
package Matrix;

/**
 * 
 * @author shubham.yeole
 * 
 *         Given a sorted matrix mat[n][m] and an element ‘x’. Find position of
 *         x in the matrix if it is present, else print -1. Matrix is sorted in
 *         a way such that all elements in a row are sorted in increasing order
 *         and for row ‘i’, where 1 <= i <= n-1, first element of row 'i' is
 *         greater than or equal to the last element of row 'i-1'. The approach
 *         should have O(log n + log m) time complexity.
 *
 */

public class Searcha2DMatrixII240 {

	public static void main(String[] args) {

		Searcha2DMatrixII240 cn = new Searcha2DMatrixII240();

		int[][] mat = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		System.out.println(cn.searchMatrix(mat, 3));
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0)
			return false;

		for (int i = 0; i < matrix.length; i++) {
			int ans = searchRow(matrix[i], 0, matrix[i].length - 1, target);
			if (ans < 0)
				continue;
			if (matrix[i][ans] == target)
				return true;
		}

		return false;
	}

	private int searchRow(int[] row, int top, int bottom, int target) {
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
			return searchRow(row, top, mid, target);

		if (target > row[mid])
			return searchRow(row, mid, bottom, target);

		return -1;
	}
}
