package com.mingyangdai;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static String solution(String line) {
		// 在此处理单行数据
		String[] array = line.split(" ");
		int cur = Integer.parseInt(array[1]), target = Integer.parseInt(array[2]);
		
		int num = 0;
		char[] chars = array[0].toCharArray();
		for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
			int k;
			if (Character.isDigit(chars[i])) {
				k = chars[i] - '0';
			} else {
				k = chars[i] - 'a' + 10;
			}
			num += k * Math.pow(cur, j);
		}
		
		String[] map = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
		StringBuilder res = new StringBuilder();
		while (num > 0) {
			int i = num % target;
			res.append(map[i]);
			num /= target;
		}
		// 返回处理后的结果
		return res.reverse().toString();
	}
	
	public static void main(String[] args) {
		String line = "31 10 16";
		String res = solution(line);
		System.out.println(res);
	}
}
