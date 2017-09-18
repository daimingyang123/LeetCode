package com.mingyangdai.array;

import java.util.Arrays;

/**
 * @author mingyang.dai
 * @since 2017/9/17
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    
    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] nums = {0,8,4,12,2};
        int res = subsequence.lengthOfLIS(nums);
        System.out.println(res);
    }
}
