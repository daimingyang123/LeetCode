package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 17/3/3
 */
public class HouseRobber2 {
	public int rob(int[] nums) {
		int max = 0;
		
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length-1; i++) {
			dp[i] = nums[i];
			if (i > 2) {
				dp[i] += Math.max(dp[i-2], dp[i-3]);
			} else if (i > 1) {
				dp[i] += dp[i-2];
			}
			max = Math.max(max, dp[i]);
		}
		
		dp[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i];
			if (i > 2) {
				dp[i] += Math.max(dp[i-2], dp[i-3]);
			} else if (i > 1) {
				dp[i] += dp[i-2];
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		HouseRobber2 robber2 = new HouseRobber2();
		int[] nums = {1,5,8,10,15,7,13};
		int res = robber2.rob(nums);
		System.out.println(res);
	}
}
