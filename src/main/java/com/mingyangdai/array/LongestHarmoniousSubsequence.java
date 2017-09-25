package com.mingyangdai.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2017/9/22
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        
        int res = 0;
        for (int n : nums) {
            int count = map.get(n);
            
            int min = count + map.getOrDefault(n-1, 0);
            res = Math.max(res, min);
            
            int max = count + map.getOrDefault(n+1, 0);
            res = Math.max(res, max);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        LongestHarmoniousSubsequence subsequence = new LongestHarmoniousSubsequence();
        int[] nums = {1,1,1,1};
        int res = subsequence.findLHS(nums);
        System.out.println(res);
    }
}
