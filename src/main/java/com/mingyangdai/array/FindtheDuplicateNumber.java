package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/3/19
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            int val = nums[index];
            if (val < 0) return Math.abs(val);
            nums[i] = -nums[index];
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int res = new FindtheDuplicateNumber().findDuplicate(new int[]{1,1});
        System.out.println(res);
    }
}
