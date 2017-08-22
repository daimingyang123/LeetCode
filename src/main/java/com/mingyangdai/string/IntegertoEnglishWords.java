package com.mingyangdai.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/8/22
 */
public class IntegertoEnglishWords {
	public String numberToWords(int num) {
		String s = Integer.toString(num);
		StringBuilder res = new StringBuilder();
		List<String> substrings = split(s, 3);
		rea.append()
	}
	
	private List<String> split(String s, int length) {
		List<String> res = new ArrayList<String>();
		while (s.length() > length) {
			int start = s.length()-length;
			String substring = s.substring(start, s.length());
			res.add(substring);
			s = s.substring(0, start);
		}
		if (!s.isEmpty()) res.add(s);
		return res;
	}
	
	private String getWords(String s) {
		StringBuilder res = new StringBuilder();
		char[] array = s.toCharArray();
		if (array.length > 0) {
			res.append(getWord(array[0]));
		}
	}
	
	private String getWord(char c) {
	
	}
}
