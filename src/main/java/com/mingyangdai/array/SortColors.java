package com.mingyangdai.array;

/**
 * @author mingyang.dai
 * @since 2018/4/9
 */
public class SortColors {
    
    public void sortColors(int[] nums) {
        int second = nums.length - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) {
                swap(nums, i, second--);
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero++);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1,0,1,2};
        new SortColors().sortColors(nums);
        System.out.println(nums);
    }
}
