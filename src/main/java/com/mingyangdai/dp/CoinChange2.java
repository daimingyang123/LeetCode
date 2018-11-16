package com.mingyangdai.dp;

/**
 * @author mingyang.dai
 * @since 2018/10/13
 */
public class CoinChange2 {
	
	private int count;
	
	public int change(int amount, int[] coins) {
		count = 0;
		
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		make(amount, coins, 0, dp);
		return count;
	}
	
	private int make(int target, int[] coins, int i, int[] dp) {
		if (dp[target] != 0) {
			count++;
			return 1;
		}
		for (int j = i; j < coins.length && coins[j] <= target; j++) {
			int res = make(target - coins[j], coins, j, dp);
			if(res != 0) {
				dp[target] = 1;
			}
		}
		return dp[target];
	}
	
	public static void main(String args[]) {
		int amount = 5;
		int[] coins = new int[]{1,2};
		int res = new CoinChange2().change(amount, coins);
		System.out.println(res);
	}
}
