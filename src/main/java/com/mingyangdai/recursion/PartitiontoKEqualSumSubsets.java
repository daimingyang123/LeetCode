package com.mingyangdai.recursion;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/5/3
 */
public class PartitiontoKEqualSumSubsets {
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
			list.add(i);
			sum += nums[i];
		}
		if (sum % k != 0) return false;
		
		Arrays.sort(nums);
		return partition(nums, 0, sum/k, k, map);
	}
	
	private boolean partition(int[] nums, int cur, int sum, int count, HashMap<Integer, List<Integer>> map) {
		if (cur == sum) {
			cur = 0;
			count -= 1;
		}
		if (count == 0) return true;
		if (cur > sum) return false;
		
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = map.getOrDefault(sum - count);
			if (!list.isEmpty())
			if (nums[i] == 0) continue;
			int n = nums[i];
			nums[i] = 0;
			if (partition(nums, cur + n, sum, count, map)) return true;
			nums[i] = n;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{4,3,2,3,5,2,1};
		int k = 4;
		boolean res = new PartitiontoKEqualSumSubsets().canPartitionKSubsets(nums, k);
		System.out.println(res);
	}
}
