//https://leetcode.com/problems/powx-n
package Bucket;

public class PowXN50 {
	public static void main(String[] args) {
		PowXN50 pow = new PowXN50();
		System.out.println(pow.myPow(2.00000, 100));
		System.out.println(pow.myPow(2.00000, -2));
	}
	
	private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);
        
//        System.out.printf("Product: %s - n: %s\n", half, n);

       
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
	
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
}
