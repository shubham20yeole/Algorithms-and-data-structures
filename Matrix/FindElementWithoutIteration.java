package Matrix;

/**
 * 
 * @author shubham.yeole
 * 
 * Given a sorted matrix mat[n][m] and an element ‘x’. Find position of x in the matrix if it is present, else print -1. 
 * Matrix is sorted in a way such that all elements in a row are sorted in increasing order and for row ‘i’, 
 * where 1 <= i <= n-1, first element of row 'i' is greater than or equal to the last element of row 'i-1'. 
 * The approach should have O(log n + log m) time complexity. 
 *
 */

public class FindElementWithoutIteration {

	public static void main(String[] args) {
		int[][] mat = new int[10][10];
		
		int count = 1;
		
		for(int row = 0; row < mat.length; row++) {
			for(int col = 0; col < mat[row].length; col++) {
				mat[row][col] = count++;
			}
		}
		
		int[] ans = findIndexOf(25, mat);
		
		System.out.println(ans[0] + " : " + ans[1] + " : " + mat[ans[0]][ans[1]]);
	}

	private static int[] findIndexOf(int no, int[][] mat) {

		int lastRow = mat.length,
			firstRow = 0,
			medianRowIndex = getMedian(firstRow, lastRow),
			hardCoadColIndex = 0;
		
		
		while(!(lastRow-firstRow <= 1)) {
			if(no < mat[medianRowIndex][hardCoadColIndex]) {
				lastRow = medianRowIndex;
				medianRowIndex = getMedian(firstRow, lastRow);
			} else {
				firstRow = medianRowIndex;
				medianRowIndex = getMedian(firstRow, lastRow);
			}
		
		}
		
		// Once you are here, you already found the row in which your element is located
		// Not its time to find column index
				
		int[] rowArray = mat[medianRowIndex];
		
		int rightIndex = rowArray.length,
			leftIndex = 0,
			medianColIndex = getMedian(leftIndex, rightIndex);
		
		while(!(rightIndex-leftIndex <= 1)) {
			if(no < rowArray[medianColIndex]) {
				rightIndex = medianColIndex;
				medianColIndex = getMedian(leftIndex, rightIndex);
			} else {
				leftIndex = medianColIndex;
				medianColIndex = getMedian(leftIndex, rightIndex);
			}
		}
		
		return new int[] {medianRowIndex, medianColIndex};
	}

	private static int getMedian(int l, int h) {
		return l + ((h-l)/2);
	}
}
