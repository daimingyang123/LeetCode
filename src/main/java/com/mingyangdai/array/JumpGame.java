package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/4/10
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		return canJump(nums, 0, new Boolean[nums.length]);
	}
	
	private Boolean canJump(int[] nums, int i, Boolean[] dp) {
		if (dp[i] != null) return dp[i];
		
		int end = i + nums[i];
		if (end >= nums.length - 1) {
			dp[i] = true;
			return dp[i];
		}
		for (int j = end; j > i; j--) {
			if (canJump(nums, j, dp)) {
				dp[i] = true;
				return dp[j];
			}
		}
		dp[i] = false;
		return dp[i];
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1};
		boolean res = new JumpGame().canJump(nums);
		System.out.println(res);
	}
}
