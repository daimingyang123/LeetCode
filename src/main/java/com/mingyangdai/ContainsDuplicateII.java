package com.mingyangdai;

import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 2017/7/8
 */
public class ContainsDuplicateII {
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 7, 9, 10, 1};
		int k = 6;
		ContainsDuplicateII containsDuplicateIII = new ContainsDuplicateII();
		boolean res = containsDuplicateIII.containsNearbyDuplicate(nums, k);
		System.out.println(res);
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.size() == k) set.remove(nums[i - k]);
			if (!set.add(nums[i])) return true;
		}
		return false;
	}
}
