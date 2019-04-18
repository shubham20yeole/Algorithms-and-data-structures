package String;

import java.util.LinkedList;
import java.util.List;

public class ToggleCharacter {

	/*
	 * METHOD 1 WITH ITERATION
	 */
	public static String toggleCharInString(String input) {
		if (input.length() == 0)
			return "Invalid input";

		StringBuffer result = new StringBuffer();
		for (char curr : input.toCharArray()) {
			result.append(getToggleCharacter(curr));
		}

		return result.toString();
	}

	/*
	 * METHOD 2: METHOD WITH RECURSION
	 */
	public static StringBuffer withRecursion(char curr, String input, StringBuffer result, int index) {
		result.append(getToggleCharacter(curr));
		if (++index >= input.length())
			return result;
		withRecursion(input.charAt(index), input, result, index);
		return result;
	}

	/*
	 * METHOD 3: WITH LAMBDA FUNCTION
	 */
	public static String withLambdaFunction(String input) {
		StringBuffer result = new StringBuffer();
		List<Character> charList = new LinkedList<Character>(getCharacterArray(input));
		charList.forEach(c -> {
			result.append(getToggleCharacter(c));
		});
		return result.toString();
	}

	/*
	 * MAIN FUNCTION
	 */
	public static void main(String[] Args) {
		String str = "AaZzXx CcVvDd : ; ' @ }] ";
		System.out.println(toggleCharInString(str));
		System.out.println(withRecursion(str.charAt(0), str, new StringBuffer(), 0).toString());
		System.out.println(withLambdaFunction(str));

	}

	// UTIL FUNCTION TO TOGGLE SMALL CAPITAL CHARACTER
	public static char getToggleCharacter(char curr) {
		if (Character.isUpperCase(curr)) {
			return Character.toLowerCase(curr);
		}
		return Character.toUpperCase(curr);
	}

	// UTIL FUNCTION TO CONVERT ARRAY TO LIST
	public static List<Character> getCharacterArray(String input) {
		List<Character> wrapperClassCharacterList = new LinkedList<Character>();
		for (char c : input.toCharArray())
			wrapperClassCharacterList.add(c);
		return wrapperClassCharacterList;
	}
}