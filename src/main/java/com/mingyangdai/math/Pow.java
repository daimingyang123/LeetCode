package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2018/2/27
 */
public class Pow {
	private double fastPow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		double half = fastPow(x, n / 2);
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
	
	public static void main(String[] args) {
		double x = 2;
		int n = 10;
		double res = new Pow().myPow(x, n);
		System.out.println(res);
	}
}
