//https://leetcode.com/problems/super-ugly-number/description/
package Array;

import java.util.*;

/**
 * 
 * @author shubham.yeole
 * @Reference: https://leetcode.com/problems/super-ugly-number/description/
 *
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Example:
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32 
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 *
 * Note:
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * 
 */

public class SuperUglyNumber {
	public static void main(String[] args) {
		int n = 12;
		Integer[] primes = new Integer[] {2,7,13,19};
		
		System.out.println(findSuperUglyNumber(n, primes));
	}

	private static int findSuperUglyNumber(int n, Integer[] primes) {
		
		int count = 1, sequence = 1;
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(primes));
		
		while(count != n) {
			sequence++;
			Set<Integer> set = primeFactors(sequence);
			if(list.containsAll(set)) {
				count++;
			};
		}
		
		return sequence;
	}

	
	// Function to return all prime factors set
	
	private static Set<Integer> primeFactors(int sequence) {
		Set<Integer> set = new HashSet<Integer>();
		
		int number = 2;
		while(sequence != 1) {
			if (sequence % number == 0) {
				set.add(number);
				sequence = sequence / number;
			} else {
				number++;
			}
		}
		return set;
	}
}
