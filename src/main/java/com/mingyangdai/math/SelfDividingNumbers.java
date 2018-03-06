package com.mingyangdai.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/2/13
 */
public class SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList<>();
		for (int i=left; i<=right; i++) {
			if (isValid(i)) {
				res.add(i);
			}
		}
		return res;
	}
	
	private boolean isValid(int n) {
		String s = Integer.toString(n);
		for (char c : s.toCharArray()) {
			int d = c-'0';
			System.out.println(d);
			if (n % d != 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int left = 1;
		int right = 22;
		List<Integer> res = new SelfDividingNumbers().selfDividingNumbers(left, right);
		System.out.println(res);
	}
}
