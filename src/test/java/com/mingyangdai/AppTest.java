package com.mingyangdai;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.sort((o1, o2) -> {
			char[] array1 = o1.toCharArray();
			char[] array2 = o2.toCharArray();
			int length = Math.min(array1.length, array2.length);
			for (int i = 0; i < length; i++) {
				if (array1[i] == array2[i]) continue;
				return array2[i]-array1[i];
			}
			if (array1.length > array2.length) {
				return array1[length] - array1[0] > 0 ? 1 : -1;
			} else {
				return array2[length] - array2[0] > 0 ? -1 : 1;
			}
		});
	}
}
