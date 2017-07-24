package com.mingyangdai;

import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 17/4/10
 */
public class BitManipulation {
	
	private HashSet<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) {
		BitManipulation bitManipulation = new BitManipulation();
		int num = 19;
		boolean result = bitManipulation.isHappy(num);
		System.out.println(result);
	}
	
	public boolean isHappy(int n) {
		int temp, result = 0;
		while (true) {
			while (n > 0) {
				temp = n % 10;
				result += temp * temp;
				n = n / 10;
			}
			
			if (result == 1) return true;
			if (set.contains(result)) return false;
			
			set.add(result);
			n = result;
		}
	}
}
