//https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
package zOthers;

import java.util.*;

public class PrimeFactors {
  public static void main(String[] args) {
  	
  	
  	
  	char c = '9';
  	System.out.println(c-'0' + 1);
  	
  	
      int number = 4;
      int count = 2;
      
      Set<Integer> set = new HashSet<Integer>();
      
     while(number != 1) {
    	 if (number % count == 0) {
    		 set.add(count);
    		 number = number / count;
    	 } else {
    		 count++;
    	 }
     }
     
     set.forEach((k) -> System.out.print(k + ", "));
     
  }
}


//or (int i = 2; i <= number; i++) {
//  count = 0;
//  while (number % i == 0) {
//      number /= i;
//      count++;
//  }
//  if (count == 0) {
//       continue;
//  }
//  System.out.println(i+ "**" + count);
//}