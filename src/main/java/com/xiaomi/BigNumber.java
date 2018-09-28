package com.xiaomi;

/**
 * @author mingyang.dai
 * @since 2018/7/14
 */
public class BigNumber {
	private static String solution(String line) {
		StringBuilder res = new StringBuilder();
		// 在此处理单行数据
		String[] array = line.split(" ");
		char[] a = array[0].toCharArray();
		char[] b = array[2].toCharArray();
		int carry = 0;
		for (int i = 1; i <= a.length; i++) {
			int f = a[a.length - i] - '0';
			int s = i <= b.length ? b[b.length - i] - '0' : 0;
			int diff = f - s - carry;
			if (diff < 0) {
				diff += 10;
				carry = 1;
			} else {
				carry = 0;
			}
			res.append(diff);
		}
		// 返回处理后的结果
		return Integer.toString(1);
	}
	
	public static void main(String[] args) {
		String line = "453 - 29";
		String res = solution(line);
		System.out.println(res);
	}
}
