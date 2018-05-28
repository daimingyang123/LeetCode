package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2018/5/8
 */
public class Sqrt {
	public int mySqrt(int x) {
		if (x == 0) return x;
		int start = 1, end = x/2 + 1;
		while(start <= end){
			double mid = (start + end)/2;
			double square = mid * mid;
			int i = (int) mid;
			if (square == x) return i;
			if (square > x) end = i - 1;
			else start = i + 1;
		}
		return start - 1;
	}
	
	public static void main(String[] args) {
		int res = new Sqrt().mySqrt(2147395599);
		System.out.println(res);
	}
}
