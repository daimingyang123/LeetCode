package com.mingyangdai.backtracking;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/4/2
 */
public class PartitiontoKEqualSumSubsets {
    private int res;
    private HashMap<Integer, Integer> map;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        res = 0;
        map = new HashMap<>();
        
        int sum = 0;
        for (int i : nums) {
            sum += i;
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        if (sum % k != 0) return false;
        
        int target = sum / k;
        partition(target);
        
        return res == k;
    }
    
    private void partition(int target) {
        if (target < 0) return;
        
        Integer count = map.get(target);
        if (count != null && count != 0) {
            map.replace(target, count - 1);
            res++;
            return;
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count = entry.getValue();
            if (count == 0) continue;
            
            Integer key = entry.getKey();
            entry.setValue(count - 1);
            partition(target - key);
            
            entry.setValue(count);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean res = new PartitiontoKEqualSumSubsets().canPartitionKSubsets(nums, k);
        System.out.println(res);
    }
}
