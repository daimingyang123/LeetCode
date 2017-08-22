package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public void test() {
		List<Integer> list = new ArrayList<>();
		boolean flag = list.isEmpty();
		System.out.println(flag);
	}
	
	public static void main(String[] args) {
		AppTest test = new AppTest();
//		test.test();
		int n = (int) Math.pow(2, 31);
		System.out.println(n);
		String s = "";
	}
}
