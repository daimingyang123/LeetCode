package com.mingyangdai;

import java.util.TreeMap;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		TreeMap<String, String> map = new TreeMap<String, String>((o1, o2) -> {
			char[] array1 = o1.toCharArray();
			char[] array2 = o2.toCharArray();
			for (int i = 0; i < Math.min(array1.length, array2.length); i++) {
				if (array1[i] == ' ') return -1;
				if (array2[i] == ' ') return 1;
				if (array1[i] != array2[i]) return array1[i] - array2[i];
			}
			return array1.length - array2.length;
		});
	}
}
