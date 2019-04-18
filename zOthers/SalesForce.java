//
package zOthers;

import Utils.Utils;

public class SalesForce {
	static Utils utils = new Utils();
	Utils util = new Utils();

	public static void main(String[] args) {
		SalesForce cn = new SalesForce();
		String s0 = "abc";
		String s1 = "ABC";
		String s2 = "123";
		String s3 = "aAbC";
		String s4 = "xyz05AB9C";
		String s5 = "15aABCDb6789c";
		String s6 = "1X2a3Y4b5Z6c";
		System.out.println(s0 + " -> " + cn.inPlaceStringManipulation(s0));
		System.out.println(s1 + " -> " + cn.inPlaceStringManipulation(s1));
		System.out.println(s2 + " -> " + cn.inPlaceStringManipulation(s2));
		System.out.println(s3 + " -> " + cn.inPlaceStringManipulation(s3));
		System.out.println(s4 + " -> " + cn.inPlaceStringManipulation(s4));
		System.out.println(s5 + " -> " + cn.inPlaceStringManipulation(s5));
		System.out.println(s6 + " -> " + cn.inPlaceStringManipulation(s6));
	}

	// Question: Given a string consists of only upper letters, lower letters, move
	// string element so that it become upper letters followed by lower letters,
	// finally followed by digits. Original order in each category should be
	// maintained.
	// SPACE: O(1)
	// TIME: O(N^2) where n is length of string
	public String inPlaceStringManipulation(String str) {
		int leftPtr = 0, rightPtr = str.length();
		char curr;

		for (int i = 0; i < str.length(); i++) {
			curr = str.charAt(i);

			if (Character.isDigit(curr) && i < rightPtr) {
				str = str.substring(0, i) + str.substring(i + 1, str.length()) + curr;
				rightPtr--;
				i--;
				continue;
			}

			if (Character.isUpperCase(curr)) {
				str = str.substring(0, leftPtr) + curr + str.substring(leftPtr, i) + str.substring(i + 1, str.length());
				leftPtr++;
			}
		}
		return str;
	}
}
