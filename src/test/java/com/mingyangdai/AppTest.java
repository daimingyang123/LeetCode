package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
		int a = 0/1;
		System.out.println(a);
		int b = 1/0;
		System.out.println(b);
		TreeSet<Integer> set = new TreeSet<>();
		int c = set.ceiling(5);
	}
}
