package com.mingyangdai;

/**
 * @author mingyang.dai
 * @since 16/2/21
 */


public class Race {
	
	public static void main(String[] args) {
		Race race = new Race();
//        int n  = 5;
//        boolean result = race.isPowerOfTwo(n);
//        System.out.println(result);
		for (int i = 1; i < 10; i++) {
			StringBuilder builder = new StringBuilder(Integer.toBinaryString(2 * i));
			while (builder.length() < 32) {
				builder.insert(0, "0");
			}
			System.out.println(builder.toString());
		}
	}
	
	int closestSequence2(int[] a, int[] b) {
		final int Infinity = Integer.MAX_VALUE;
		int dp[][] = new int[a.length + 1][b.length + 1];
		for (int i = 0; i <= a.length; i++) {
			for (int j = 0; j <= b.length; j++) {
				dp[i][j] = Infinity;
			}
		}
		
		dp[0][0] = 0;
//    For a = [1, 2, 6] and b = [0, 1, 3, 4, 5]
// the best subsequence will be b' = [1, 3, 5] with the difference 2.
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (dp[i][j] == Infinity) {
					continue;
				}
				dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + Math.abs(a[i] - b[j]));
				dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j]);
			}
		}
		
		return dp[a.length][b.length];
	}
	
	public boolean isPowerOfTwo(int n) {
		int start = 1;
		while (start < n) {
			start = start << 1;
		}
		return start == n;
	}
	
}
