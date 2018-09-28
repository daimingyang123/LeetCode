package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/8/18
 */
public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		List<Integer> list = new ArrayList<>();
		while (x > 0) {
			list.add(x % 10);
			x /= 10;
		}
		int res = 0;
		for (int i : list) {
			res = res*10 + i;
		}
		return res == x;
	}
	
	public static void main(String args[]) {
		boolean res = new PalindromeNumber().isPalindrome(12321);
		System.out.println(res);
	}
}
