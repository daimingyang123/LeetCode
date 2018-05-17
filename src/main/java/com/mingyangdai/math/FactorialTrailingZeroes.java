package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2018/5/16
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
	
	public static void main(String[] args) {
		int res = new FactorialTrailingZeroes().trailingZeroes(125);
		System.out.println(res);
	}
}
