package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2017/9/6
 */
public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		double x = numerator % 10, y = denominator;
		while (x != 0 && x%y != x) {
			x = x%y;
		}
		if (x == 0) return Double.toString(x/y);
		String res = Double.toString(x/y);
		String last = "(" + res.charAt(res.length()-2) + ")";
		String[] array = res.split("\\.");
		res = array[0] + "." + last;
		return res;
	}
	
	public static void main(String[] args) {
		FractiontoRecurringDecimal decimal = new FractiontoRecurringDecimal();
		int n = 200, d = 3;
		String res = decimal.fractionToDecimal(n, d);
		System.out.println(res);
	}
}
