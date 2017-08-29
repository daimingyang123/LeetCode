package com.mingyangdai.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/8/22
 */
public class IntegertoEnglishWords {
	
	public String numberToWords(int num) {
		if (num == 0) return "Zero";
		
		String s = Integer.toString(num);
		StringBuilder res = new StringBuilder();
		List<String> substrings = split(s, 3);
		if (substrings.size() > 0) {
			res.insert(0, substrings.get(0));
		}
		if (substrings.size() > 1 && !substrings.get(1).isEmpty()) {
			res.insert(0, " ");
			res.insert(0, "Thousand");
			res.insert(0, " ");
			res.insert(0, substrings.get(1));
		}
		if (substrings.size() > 2 && !substrings.get(2).isEmpty()) {
			res.insert(0, " ");
			res.insert(0, "Million");
			res.insert(0, " ");
			res.insert(0, substrings.get(2));
		}
		if (substrings.size() > 3 && !substrings.get(3).isEmpty()) {
			res.insert(0, " ");
			res.insert(0, "Billion");
			res.insert(0, " ");
			res.insert(0, substrings.get(3));
		}
		return res.toString().trim();
	}
	
	private List<String> split(String s, int length) {
		List<String> res = new ArrayList<>();
		while (s.length() > length) {
			int start = s.length()-length;
			String substring = s.substring(start, s.length());
			res.add(getWords(substring));
			s = s.substring(0, start);
		}
		if (!s.isEmpty()) res.add(getWords(s));
		return res;
	}
	
	private String getWords(String s) {
		StringBuilder res = new StringBuilder();
		char[] array = s.toCharArray();
		int length = array.length;
		if (length == 1) {
			return getWord(array[0]);
		}
		if (length > 1) {
			if (s.charAt(length-2)-'0' > 0) {
				res.insert(0, " ");
				String word;
				if (s.charAt(length-2) == '1') {
					word = getDoubleDigit(s.substring(length-2));
				} else {
					res.insert(0, getWord(array[length-1]));
					res.insert(0, " ");
					word = getDecade(array[length-2]);
				}
				res.insert(0, word);
			}
		}
		if (length > 2 && array[length-3]-'0' > 0) {
			res.insert(0, " ");
			res.insert(0, "Hundred");
			res.insert(0, " ");
			res.insert(0, getWord(array[length-3]));
		}
		return res.toString().trim();
	}
	
	private String getWord(char c) {
		switch (c) {
			case '1':
				return "One";
			case '2':
				return "Two";
			case '3':
				return "Three";
			case '4':
				return "Four";
			case '5':
				return "Five";
			case '6':
				return "Six";
			case '7':
				return "Seven";
			case '8':
				return "Eight";
			case '9':
				return "Nine";
			default:
				return "";
		}
	}
	
	private String getDoubleDigit(String s) {
		if (s.equals("10")) return "Ten";
		if (s.equals("11")) return "Eleven";
		if (s.equals("12")) return "Twelve";
		if (s.equals("13")) return "Thirteen";
		if (s.equals("14")) return "Fourteen";
		if (s.equals("15")) return "Fifteen";
		if (s.equals("16")) return "Sixteen";
		if (s.equals("17")) return "Seventeen";
		if (s.equals("18")) return "Eighteen";
		if (s.equals("19")) return "Nineteen";
		else return "";
	}
	
	private String getDecade(char c) {
		switch (c) {
			case '2':
				return "Twenty";
			case '3':
				return "Thirty";
			case '4':
				return "Forty";
			case '5':
				return "Fifty";
			case '6':
				return "Sixty";
			case '7':
				return "Seventy";
			case '8':
				return "Eighty";
			case '9':
				return "Ninety";
			default:
				return "";
		}
	}
	
	public static void main(String[] args) {
		IntegertoEnglishWords words = new IntegertoEnglishWords();
		int num = 100020013;
		String res = words.numberToWords(num);
		System.out.println(res);
	}
	
}
