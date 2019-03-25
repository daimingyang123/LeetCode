package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2018/2/27
 */
public class Pow {
	public double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		double ans = 1;
		double current_product = x;
		for (long i = N; i > 0; i /= 2) {
			if ((i % 2) == 1) {
				ans = ans * current_product;
			}
			current_product = current_product * current_product;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		double x = 2;
		int n = 10;
		double res = new Pow().myPow(x, n);
		System.out.println(res);
	}
}
