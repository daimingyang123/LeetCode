package com.mingyangdai;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author mingyang.dai
 * @since 2017/7/8
 */
public class ContainsDuplicateIII {
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 7, 9, 10};
		int k = 1;
		int t = 1;
		ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
		boolean res = containsDuplicateIII.containsNearbyAlmostDuplicate(nums, k, t);
		System.out.println(res);
	}
	
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		Map<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i];
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}
		
		final TreeSet<Integer> values = new TreeSet<Integer>();
		for (int ind = 0; ind < nums.length; ind++) {
			
			final Integer floor = values.floor(nums[ind] + t);
			final Integer ceil = values.ceiling(nums[ind] - t);
			if ((floor != null && floor >= nums[ind])
					|| (ceil != null && ceil <= nums[ind])) {
				return true;
			}
			
			values.add(nums[ind]);
			if (ind >= k) {
				values.remove(nums[ind - k]);
			}
		}
		
		return false;
	}
}
