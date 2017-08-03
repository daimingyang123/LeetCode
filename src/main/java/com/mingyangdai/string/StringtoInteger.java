package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2017/8/3
 */
public class StringtoInteger {
	public int myAtoi(String str) {
		str = str.trim();
		char[] array = str.toCharArray();
		long res = 0;
		long pow = 1;
		for (int i=array.length-1; i>0; i--) {
			int val = array[i]-'0';
			if (val < 0 || val > 9) continue;
			res += val*pow;
			if (res < -2147483648) return -2147483648
		}
	}
}
