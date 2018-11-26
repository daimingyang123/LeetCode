package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/10/21
 */
public class LongPressedName {
	
	public boolean isLongPressedName(String name, String typed) {
		if (name.length() == 0 || typed.length() == 0) {
			return name.length() == typed.length();
		}
		
		char[] array1 = name.toCharArray();
		char[] array2 = typed.toCharArray();
		int i = 0, j = 0;
		for (; i < array1.length && j < array2.length ; i++, j++) {
			int count1 = 1, count2 = 1;
			while (i < array1.length - 1 && array1[i] == array1[i + 1]) {
				count1++;
				i++;
			}
			while (j < array2.length - 1 && array2[j] == array2[j + 1]) {
				count2++;
				j++;
			}
			if (array1[i] != array2[j] || count1 > count2) return false;
		}
		return i == array1.length && j == array2.length;
	}
	
	public static void main(String args[]) {
		String name = "pyplrz";
		String typed = "ppyypllr";
		boolean res = new LongPressedName().isLongPressedName(name, typed);
		System.out.println(res);
	}
}
