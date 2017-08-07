package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2017/8/5
 */
public class LongestCommonSubsequence {
	
	public int longestCommonSubsequence(String A, String B) {
		int n = A.length();
		int m = B.length();
		int f[][] = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				if(A.charAt(i - 1) == B.charAt(j - 1))
					f[i][j] = f[i - 1][j - 1] + 1;
			}
		}
		return f[n][m];
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
					f[i][j] = 0;
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
	public static void main(String[] args) {
		String a = "abcd";
		String b = "aacd";
		LongestCommonSubsequence LCS = new LongestCommonSubsequence();
		int res = LCS.longestCommonSubstring(a, b);
		System.out.println(res);
	}
}
