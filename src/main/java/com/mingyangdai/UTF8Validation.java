package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2018/9/26
 */
public class UTF8Validation {
	public boolean validUtf8(int[] data) {
		int i = 0;
		while (i < data.length) {
			char[] array = Integer.toBinaryString(data[i]).toCharArray();
			if (array.length < 8) {
				i++;
				continue;
			}
			if (array[1] == '0') {
				return false;
			}
			//11110000
			int j = 0;
			for (; j < array.length; j++) {
				if (array[j] == '0') {
					break;
				}
			}
			//i = 0, j = 4
			if (j - i > 4 || data.length < i + j) {
				return false;
			}
			

			i++;
			for (; i < j; i++) {
				String b = Integer.toBinaryString(data[i]);
				if (b.length() != 8 || !b.startsWith("10")) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		int[] data = new int[]{228,189,160,229,165,189,13,10};
		boolean res = new UTF8Validation().validUtf8(data);
		System.out.println(res);
	}
}
