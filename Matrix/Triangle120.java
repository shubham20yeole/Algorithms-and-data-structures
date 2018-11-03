//https://leetcode.com/problems/triangle/
package Matrix;

import Utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		Triangle120 cn = new Triangle120();
		// Integer[][] mat = new Integer[][] { { -1 }, { 2, 3 }, { 1, -1, -3 } };
		Integer[][] mat = new Integer[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		// Integer[][] mat = new Integer[][] {};

		List<List<Integer>> triangle = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			List<Integer> subTri = new ArrayList<Integer>(Arrays.asList(mat[i]));
			triangle.add(subTri);
		}

		System.out.println(triangle);

		utils.printLine(cn.minimumTotal(triangle));

	}

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0 || triangle.get(0).size() == 0)
			return 0;

		if (triangle.size() == 1 && triangle.get(0).size() == 1)
			return triangle.get(0).get(0);

		int sum = Integer.MAX_VALUE, curr;
		List<Integer> row, prevRow = triangle.get(0);
		boolean left, right;

		for (int i = 1; i < triangle.size(); i++) {
			row = triangle.get(i);
			for (int j = 0; j < row.size(); j++) {
				left = j - 1 >= 0;
				right = j < prevRow.size();
				curr = row.get(j);
				row.remove(j);

				if (left && right)
					row.add(j, Math.min(curr + prevRow.get(j), curr + prevRow.get(j - 1)));
				else if (!left)
					row.add(j, curr + prevRow.get(j));
				else if (!right)
					row.add(j, curr + prevRow.get(j - 1));

				if (i == triangle.size() - 1)
					sum = Math.min(sum, row.get(j));
			}

			prevRow = row;
		}

		System.out.println(triangle);

		return sum == Integer.MAX_VALUE ? 0 : sum;
	}
}
