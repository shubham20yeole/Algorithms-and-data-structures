//https://leetcode.com/problems/rotate-image
package Matrix;
import java.util.*;

import Utils.*;

public class RotateImage48 {
	public static void main(String[] args) {
		Integer[][] mat = new Integer[][] {{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}};
			
			Utils utils = new Utils();
			RotateImage48 ri = new RotateImage48();
			
			
			utils.printMatrix(mat); // Print matrix before modification
			
			ri.rotate(mat); // Rotate matrix
			
			utils.printLine(); // Print single line

			utils.printMatrix(mat); // Print matrix after modification

	}

	
	public void rotate(Integer[][] matrix) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int maxLen = matrix.length - 1;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				int newRow = col;
				int newCol = maxLen - row;
				map.put(newRow+"-"+newCol, matrix[newRow][newCol]);
				matrix[newRow][newCol] = (map.containsKey(row+"-"+col)) ? map.get(row+"-"+col) : matrix[row][col];
			}
		}
    }
}
