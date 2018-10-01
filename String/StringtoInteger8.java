//https://leetcode.com/problems/string-to-integer-atoi
package String;
import java.util.*;
import Utils.*;

public class StringtoInteger8 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		StringtoInteger8 cn = new StringtoInteger8();

		utils.printLine(cn.myAtoi("   +0 123"));

	}
	
	public int myAtoi(String str) {
		int max = Integer.MAX_VALUE;
		int sign = 1;
		String haha = "";
		boolean found = false, foundSign = false;
		for (int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if (!found && c == ' ') continue;
        	
        	if (c == ' ') break;

        	if (c == '-') {
        		found = true;
        		sign = -1;
        		continue;
        	}
        	
        	if (c == '+') {
        		found = true;
        		sign = 1;
        		continue;
        	}
        	
        	if (c == '0') {
        		found = true;
        		continue;
        	}
        	
        	

        	
    		haha = haha + c;
		}
		
		if (haha.length() == 0) return 0;
		
		util.printLine(haha);
		
		if (haha.charAt(0) == '-') {
			sign = -sign;
			str = haha.substring(1, haha.length() - 1);
		} else str = haha;
		

		if (!Character.isDigit(str.charAt(0))) return 0; 
		
		long res = 0;
        long tmp = 1L;
        for (int i = str.length() - 1; i >= 0; i--) {
        	if (tmp > max) {
        		max = max + 1;
        		return max * sign;
        	}

        	char c = str.charAt(i);
        	if (!Character.isDigit(c)) break;
        	res = res + tmp * Character.getNumericValue(c);
        	tmp = tmp * 10;
		}
        
        return (int) ((long) sign * res);
    }
}

