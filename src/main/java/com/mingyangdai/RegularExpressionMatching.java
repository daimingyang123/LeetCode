package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/6/30
 */
public class RegularExpressionMatching {
	
	public static void main(String[] args) {
		RegularExpressionMatching matching = new RegularExpressionMatching();
		String s = "aaa";
		String p = "a*a";
		boolean result = matching.isMatch(s, p);
		System.out.println(result);
	}
	
	public boolean isMatch2(String s, String p) {
		if (s.contains("*") || s.contains(".")) return false;
		int first = 0, second = 0;
		
		while (first < s.length() && second < p.length()) {
			if (p.charAt(second) == '*') {
				if (second == 0) return false;
				char pre = p.charAt(second - 1);
				if (pre == '*') return false;
				if (pre == '.') {
					if (second == p.length() - 1) {
						return true;
					} else {
						second++;
						while (first < s.length() && s.charAt(first) != p.charAt(second)) first++;
						if (first == s.length()) return false;
						while (first < s.length() && s.charAt(first) == p.charAt(second)) first++;
						second++;
					}
				} else {
					while (first < s.length() && s.charAt(first) == pre) first++;
					second++;
				}
			} else if (p.charAt(second) == '.') {
				first++;
				second++;
			} else if (s.charAt(first) != p.charAt(second)) {
				second++;
			} else {
				first++;
				second++;
			}
		}
		
		while (second < p.length() && p.charAt(second) == s.charAt(first - 1)) second++;
		
		return !(first != s.length() || second != p.length());
	}
	
	public boolean isMatch(String s, String p) {
		
		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
