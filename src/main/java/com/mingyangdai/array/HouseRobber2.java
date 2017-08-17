package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 17/3/3
 */
public class HouseRobber2 {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length-1; i++) {
			dp[i] = nums[i];
			if (i > 2) {
				dp[i] = Math.max(nums[i-2], nums[i-3]);
			} else if (i > 1) {
				dp[i] += nums[i-2];
			}
		}
		
		int[] dp2 = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i];
			if (i > 2) {
				dp[i] = Math.max(nums[i-2], nums[i-3]);
			} else if (i > 1) {
				dp[i] += nums[i-2];
			}
		}
		return 0;
	}
}
