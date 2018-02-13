package com.mingyangdai;

public class Solution {
	
//	public int findOnes(int n) {
//		if (n < 10) return 1;
//		if (n == 10) return 2;
//		if (n > 1000000000) {
//			return findOnes(1000) + n-1000 + findOnes(n-1000);
//		}
//	}
	
	public static int findOnes(int n) {
		if (n<1) return 0;
		if (n>=1 && n<10) return 1;
		int y=1, x=n;
		while (!(x<10)) {
			x/=10;
			y*=10;
		}
		if(x==1)
			return n-y+1 + findOnes(y-1) + findOnes(n%y);
		else
			return y+ x*findOnes(y-1) + findOnes(n%y);
	}
	
	public static void main(String[] args) {
		int n = 1120;
		int res = findOnes(n);
		System.out.println(res);
	}
}