package com.mingyangdai.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mingyang.dai
 * @since 2017/8/7
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		int start = 0, end = nums.length-1;
		while (start < end && nums[start] == nums[start+1]) {
			start++;
		}
		
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 3) return res;
		
		for (int i=0; i<nums.length; i++) {
			int target = 0-nums[i];
			Set<Integer> set = new HashSet<Integer>();
			for (int j=i+1; j<nums.length; j++) {
				if ( set.contains(target-nums[j]) ) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(target-nums[j]);
					res.add(list);
				}
				set.add(nums[j]);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0};
		ThreeSum sum = new ThreeSum();
		List<List<Integer>> res = sum.threeSum(nums);
		System.out.println(res);
	}
}
