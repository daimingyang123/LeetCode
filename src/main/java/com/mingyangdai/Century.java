package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 15/11/15
 */

public class Century {
	
	public static void main(String[] args) {
		Century c = new Century();
		c.century(1988);
		c.century(1700);
	}
	
	public void century(int year) {
		if (year % 100 == 0) {
			System.out.println(year / 100);
		} else {
			System.out.println(year / 100 + 1);
		}
	}
	
	
}
