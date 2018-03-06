package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/2/19
 */
public class CountBinarySubstrings {
	
	public int countBinarySubstrings(String s) {
		int[] groups = new int[s.length()];
		int t = 0;
		groups[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i-1) != s.charAt(i)) {
				groups[++t] = 1;
			} else {
				groups[t]++;
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= t; i++) {
			ans += Math.min(groups[i-1], groups[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "00110011";
		int res = new CountBinarySubstrings().countBinarySubstrings(s);
		System.out.println(res);
	}
}
