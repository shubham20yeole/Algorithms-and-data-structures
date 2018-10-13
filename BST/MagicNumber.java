package BST;

import java.util.*;
import Utils.*;

public class MagicNumber {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		MagicNumber cn = new MagicNumber();

		utils.printLine(arithmeticBoggle(2, new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4 }))));

	}

	public static boolean arithmeticBoggle(int magicNumber, ArrayList<Integer> numbers) {
		// Fill in the code here
		return arithmeticBoggle(magicNumber, numbers, 0, 0);

	}

	public static boolean arithmeticBoggle(int ans, List<Integer> arr, int index, int tmp) {
		if (arr.size() > index)
			return (arithmeticBoggle(ans, arr, index + 1, tmp + arr.get(index))
					| arithmeticBoggle(ans, arr, index + 1, tmp - arr.get(index)));
		if (ans == tmp)
			return true;
		return false;
	}
}
