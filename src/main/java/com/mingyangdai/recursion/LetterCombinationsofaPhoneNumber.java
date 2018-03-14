package com.mingyangdai.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/3/8
 */
public class LetterCombinationsofaPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
		List<String> cur = new ArrayList<>();
		if (digits == null || digits.length() == 0) return cur;
		
		cur.add("");
		String[] array = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wyxz"};
		List<String> list = new ArrayList<>();
		for (char c : digits.toCharArray()) {
			list.add(array[c-'0']);
		}
		return combination(list, 0, cur);
	}
	
	private List<String> combination(List<String> list, int index, List<String> cur) {
		if (index == list.size()) return cur;
		List<String> res = new ArrayList<>();
		for (String s : cur) {
			for (char c : list.get(index).toCharArray()) {
				res.add(s+c);
			}
		}
		return combination(list, index+1, res);
	}
	
	public static void main(String[] args) {
		List<String> res = new LetterCombinationsofaPhoneNumber().letterCombinations("23");
		System.out.println(res);
	}
}
