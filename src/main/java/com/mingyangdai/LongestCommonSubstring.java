package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 2017/7/9
 */
public class LongestCommonSubstring {
	
	public static void main(String[] args) {
		String a = "abcd";
		String b = "abd";
		LongestCommonSubstring substring = new LongestCommonSubstring();
		int res = substring.longestCommonSubstring(a, b);
		System.out.println(res);
	}
	
	public int longestCommonSubstring(String A, String B) {
		// state: f[i][j] is the length of the longest lcs
		// ended with A[i - 1] & B[j - 1] in A[0..i-1] & B[0..j-1]
		int n = A.length();
		int m = B.length();
		int[][] f = new int[n + 1][m + 1];
		
		// initialize: f[i][j] is 0 by default
		
		// function: f[i][j] = f[i - 1][j - 1] + 1 or 0
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					f[i][j] = f[i - 1][j - 1] + 1;
				} else {
					f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
				}
			}
		}
		
		// answer: max{f[i][j]}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				max = Math.max(max, f[i][j]);
			}
		}
		
		return max;
	}
}
