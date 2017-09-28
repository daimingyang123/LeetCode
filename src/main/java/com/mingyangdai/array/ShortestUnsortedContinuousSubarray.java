package com.mingyangdai.array;

import java.util.TreeMap;

/**
 * @author mingyang.dai
 * @since 2017/9/26
 */
public class ShortestUnsortedContinuousSubarray {
    
    public int findUnsortedSubarray(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Integer max = Integer.MIN_VALUE, start = -1, end = start;
        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                if (start == -1) start = i-1;
                end = i;
            }
        }
    
        if (start == -1) return 0;
        if (end == start+1) {
            Integer key = map.ceilingKey(nums[end]);
            start = key == null ? start : map.get(key);
            return end-start;
        }
        return end-start+1;
    }
    
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray subarray = new ShortestUnsortedContinuousSubarray();
        int[] nums = {1,2,4,5,3};
        int res = subarray.findUnsortedSubarray(nums);
        System.out.println(res);
    }
}
