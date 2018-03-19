package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/2/19
 */
public class CountBinarySubstrings {
	
	public int countBinarySubstrings(String s) {
		int ans = 0, prev = 0, cur = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i-1) != s.charAt(i)) {
				ans += Math.min(prev, cur);
				prev = cur;
				cur = 1;
			} else {
				cur++;
			}
		}
		return ans + Math.min(prev, cur);
	}
	
	public static void main(String[] args) {
		String s = "00110011";
		int res = new CountBinarySubstrings().countBinarySubstrings(s);
		System.out.println(res);
	}
}
