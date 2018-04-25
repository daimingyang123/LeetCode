package com.mingyangdai.recursion;

/**
 * @author mingyang.dai
 * @since 2018/4/23
 */
public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		int len = nums.length;
		int[] add = new int[len], sub = new int[len];
		add[len - 1] = nums[len - 1];
		sub[len - 1] = -nums[len - 1];
		for (int i  = len - 2; i >= 0; i--) {
			add[i] = add[i + 1] + nums[i];
			sub[i] = sub[i + 1] - nums[i];
		}
		return findWay(nums, 0, S);
	}
	
	private int findWay(int[] nums, int i, int S) {
		if (i == nums.length) {
			return S == 0 ? 1 : 0;
		}
		int sum = 0;
		sum += findWay(nums, i + 1, S - nums[i]);
		sum += findWay(nums, i + 1, S + nums[i]);
		return sum;
		
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,1,1};
		int target = 3;
		int res = new TargetSum().findTargetSumWays(nums, target);
		System.out.println(res);
	}
}
