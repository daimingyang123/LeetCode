package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 17/3/5
 */
public class Roman {
	
	public static void main(String[] args) {
		Roman roman = new Roman();
		int result = roman.romanToInt("MCMLXXVI");
		System.out.println(result);
	}
	
	public int romanToInt(String s) {
		if (s.length() == 1) return convert(s.charAt(0));
		int result = 0, times = 1;
		char[] array = s.toCharArray();
		int pre = convert(array[0]);
		int cur = convert(array[1]);
		
		if (cur > pre) {
			result = cur - pre;
		} else if (cur == pre) {
			times++;
		} else {
			result = pre + cur;
		}
		
		pre = cur;
		for (int i = 2; i < s.length(); i++) {
			cur = convert(array[i]);
			if (cur != pre) {
				if (times != 1) {
					result += pre * times;
					times = 1;
				}
				if (i + 1 < s.length()) {
					int post = convert(array[++i]);
					if (post > cur) {
						result += (post - cur);
					} else if (post == cur) {
						times++;
					} else {
						result += (cur + post);
					}
					pre = post;
				} else {
					return result + cur;
				}
			} else {
				times++;
				if (i == s.length() - 1) return result + cur;
			}
		}
		return result;
	}
	
	private int convert(char c) {
		switch (c) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
		}
		return 0;
	}
}
