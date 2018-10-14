//https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html
package Utils;

import java.util.List;

public class Utils {

	public void printLine(String data) {
		System.out.println(data);
	}

	public void printLine(Long data) {
		System.out.println(data);
	}

	public void printLine(int data) {
		System.out.println(data);
	}

	public void printLine(boolean data) {
		System.out.println(data);
	}

	public void printLine(char data) {
		System.out.println(data);
	}

	public void printLine() {
		System.out.println();
	}

	public void printMatrix(Object[][] mat) {
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[row].length; col++) {
				System.out.print(mat[row][col] + ", ");
			}
			System.out.println();
		}
	}

	public void printList(List<String> list) {
		list.forEach(item -> {
			System.out.print(item);
		});
		System.out.println();
	}

	public void printMatrix(int[][] mat) {
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[row].length; col++) {
				System.out.print(mat[row][col] + ", ");
			}
			System.out.println();
		}
	}

}
