//https://leetcode.com/problems/sqrtx/
package zOthers;

class NthRootOfNumber {

	static double root(double x, int n) {
		// your code goes here
		double min = 0.001;
		double max = Math.max(1, x);
		double mid = 0;

		while (max - min >= 0.001) {
			mid = (min + max) / 2;
			if (Math.pow(mid, n) > x) {
				max = mid;
			} else if (Math.pow(mid, n) < x) {
				min = mid;
			} else {
				break;
			}
		}

		return mid;
	}

	public static void main(String[] args) {
		System.out.println(root(100, 2));
	}

}