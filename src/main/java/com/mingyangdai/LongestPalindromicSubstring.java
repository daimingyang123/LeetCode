package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/7/8
 */
public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
			char[] array = s.toCharArray();
			int max = 0;
			String res = null;
			for (int i = 0; i < array.length; i++) {
				if (i-1 > 0 && i+1 < array.length) {
					String local = longestPalindrome(array, i-1, i+1);
					if (local.length() > max) {
						max = local.length();
						res = local;
					}
				}
				if (i+1 < array.length) {
					String local = longestPalindrome(array, i, i+1);
					if (local.length() > max) {
						max = local.length();
						res = local;
					}
				}
			}
			return res;
	}
	
	private String longestPalindrome(char[] array, int start, int end) {
		if (array[start] != array[end]) return "";
		
		while (start > 0 && end < array.length) {
			if (array[start] != array[end]) break;
			start--;
			end++;
		}
		start++;
		end--;
		int length = end-start+1;
		return new String(array, start, length);
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
		String s = "bb";
		String res = substring.longestPalindrome(s);
		System.out.println(res);
	}
	
}
