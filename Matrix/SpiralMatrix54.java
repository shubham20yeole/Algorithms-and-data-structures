//https://leetcode.com/problems/spiral-matrix
package Matrix;

import Utils.Utils;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SpiralMatrix54 {

	Set<String> set = new HashSet<String>();
	boolean[] dir = { false, true, false, false };

	public static void main(String[] args) {
		int[][] world = new int[4][4];
		Utils utils = new Utils();
		int count = 0;
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[0].length; col++) {
				world[row][col] = ++count;
			}
		}

		utils.printMatrix(world);

		int[][] test = {};

		SpiralMatrix54 sn = new SpiralMatrix54();
		System.out.println(sn.spiralOrder(test));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new LinkedList<Integer>();

		if (matrix.length == 0)
			return list;

		recursive(matrix, list, 0, 0);

		return list;
	}

	private void recursive(int[][] matrix, List<Integer> list, int row, int col) {
		boolean up, down, right, left;

		up = row - 1 < 0 || set.contains((row - 1) + "-" + col) ? false : true;
		right = col + 1 > matrix[0].length - 1 || set.contains(row + "-" + (col + 1)) ? false : true;
		down = row + 1 > matrix.length - 1 || set.contains((row + 1) + "-" + col) ? false : true;
		left = col - 1 < 0 || set.contains(row + "-" + (col - 1)) ? false : true;

		list.add(matrix[row][col]);
		set.add(row + "-" + col);

		if (!up && !down && !right && !left) {
			return;
		}

		// System.out.printf("Direction: %s|%s|%s|%s --- (%s,%s) = %s --- %s\n", up,
		// right, down, left, row, col, matrix[row][col], set);

		int nr = row, nc = col;

		if (!up && !left && (right && down || right && !down)) {
			nc++;
		}

		if (!up && !right && (left && down || !left && down)) {
			nr++;
		}

		if (!right && !down && (up && left || !up && left)) {
			nc--;
		}

		if (!left && !down && (up && right || up && !right)) {
			nr--;
		}

		recursive(matrix, list, nr, nc);

	}
}
