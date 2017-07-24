package com.mingyangdai;

import java.util.TreeMap;

/**
 * @author mingyang.dai
 * @since 2017/7/8
 */
public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
		String s = "abcdefedghi";
		String res = substring.longestPalindrome(s);
		System.out.println(res);
	}
	
	public String longestPalindrome(String s) {
		if (s.length() < 2) return s;
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		int j = 2;
		
		for (int i = 0; i < s.length(); i++) {
			
			while (j <= s.length()) {
				String first = s.substring(i, j);
				String rev = new StringBuilder(first).reverse().toString();
				if (first.equals(rev)) {
					map.put(first.length(), first);
				}
				
				String second = s.substring(j, s.length());
				if (second.length() < rev.length() || second.isEmpty()) break;
				
				if (second.contains(rev)) {
					int start = 0;
					for (int end = start + rev.length(); end < second.length(); start++, end++) {
						if (second.substring(start, end).equals(rev)) {
							if (isPalindrome(second.substring(0, start))) {
								map.put(end + j - i, s.substring(i, j + end));
								j += end;
								break;
							}
						}
					}
				} else {
					i++;
				}
				if (isPalindrome(second)) {
					map.put(second.length(), second);
				}
				j++;
			}
		}
		
		return map.lastEntry().getValue();
	}
	
	private boolean isPalindrome(String s) {
		char[] array = s.toCharArray();
		int start = 0, end = array.length - 1;
		
		while (start < end) {
			if (array[start++] != array[end--]) return false;
		}
		return true;
	}
	
}
