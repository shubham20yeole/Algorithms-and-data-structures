//
package zOthers;

import Utils.Utils;

public class TrialAndError {
	static Utils utils = new Utils();
	Utils util = new Utils();

	public static void main(String[] args) {
		TrialAndError cn = new TrialAndError();
		cn.marketo();
		utils.printLine();
	}

	public void marketo() {
		int m = -1;
		String ans = "";
		String[] array = new String[] { "It", "is", "pleasant" };

		for (String word : array) {
			if (word.length() % 2 == 0 && m < word.length()) {
				m = word.length();
				ans = word;
			}
		}
	}
}
