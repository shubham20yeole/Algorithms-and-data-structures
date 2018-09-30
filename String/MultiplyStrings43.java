//https://leetcode.com/problems/multiply-strings
package String;
import java.util.*;
import Utils.*;

public class MultiplyStrings43 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		MultiplyStrings43 cn = new MultiplyStrings43();

//		utils.printLine(cn.multiply("999", "999"));
//		utils.printLine(cn.multiply("123456789", "987654321"));
		utils.printLine(cn.multiply("498828660196", "840477629533"));
	}
	
	public String multiply(String num1, String num2) {
		long ans = 0;
    StringBuilder n1 = new StringBuilder(num1);
    StringBuilder n2 = new StringBuilder(num2);
    n2.reverse();
    n1.reverse();
    if(num1 == "0" || num2 == "0") return ans+"";
    long rem = 0;
    for(int i = 0; i < n2.length(); i++) {
    	
    	String temp = "";
    	for(int j = 0; j < i; j++) {
    		temp = temp + '0';
    	}
    	
    	int n2c = n2.charAt(i) - '0';
    	
    	for(int j = 0; j < n1.length(); j++) {
    		long n1c = n1.charAt(j) - '0';
    		long tres = n1c * n2c + rem;
      	temp = tres%10 + temp;
      	rem = tres/10;
      }
      if (rem > 0) temp = rem +""+ temp;
    	System.out.println(temp);
    	ans = ans + stringToInt(temp);
    	rem = 0;
    }
    
    if (rem > 0) return rem +""+ ans;
    return ans + ""; // 8991
  }
	
	public long stringToInt(String num1) {
		long ans = num1.charAt(num1.length() - 1) - '0';
    long mul = 10;
    
    StringBuilder sb = new StringBuilder(num1);
    sb.reverse();
    
    for(int j = 1; j < sb.length(); j++) {
    	long n1c = sb.charAt(j) - '0';
  		ans = ans + mul*n1c;
  		mul = mul * 10;
    }
    return ans;
	}
}

// 738
