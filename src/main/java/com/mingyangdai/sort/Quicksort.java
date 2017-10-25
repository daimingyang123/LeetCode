package com.mingyangdai.sort;

/**
 * @author mingyang.dai
 * @since 2017/10/25
 */
public class Quicksort {
    public void quicksort(int[] nums) {
        int pivot = partition(nums, 0, nums.length-1);
        partition(nums, 0, pivot);
        partition(nums, pivot, nums.length-1);
    }
    
    private int partition(int[] nums, int p, int r) {
        int q = p, j = p;
        while (j < r) {
            if (nums[j] < r) {
                swap(nums, j, q++);
            } else {
                j++;
            }
        }
        swap(nums, q, r);
        return q;
    }
    
    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
