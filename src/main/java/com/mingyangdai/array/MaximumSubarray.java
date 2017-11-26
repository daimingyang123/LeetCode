package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2017/11/25
 */
public class MaximumSubarray {
    
    public static int maxSubArray(int[] nums) {
        int cur = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            cur = Math.max(cur+n, n);
            max = Math.max(max, cur);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}
