//
package zOthers;

import java.util.Scanner;

public class TicTacToe {
	int r[][];
	int c[][];
	int d[][];
	int n;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		this.n = n;
		r = new int[n][2];
		c = new int[n][2];
		d = new int[2][2];
	}

	public int move(int row, int col, int player) {
		int p = player - 1;
		r[row][p]++;
		c[col][p]++;
		if (row == col) {
			d[0][p]++;
		}
		if (row + col == n - 1) {
			d[1][p]++;
		}
		if (r[row][p] == n || c[col][p] == n || d[0][p] == n || d[1][p] == n) {
			return player;
		}
		return 0;
	}

	public static void main(String[] args) {
		int n = 3;
		TicTacToe cn = new TicTacToe(n);
		Scanner myObj = new Scanner(System.in); // Create a Scanner object

		for (int i = 0; i < n * n; i++) {
			System.out.println("Enter row, col and player in row,col,player format");
			String input = myObj.nextLine();
			String[] inputs = input.split(",");
			int response = cn.move(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
			if (response != 0) {
				System.out.println("Winner is: " + response);
				break;
			}

		}
	}
}