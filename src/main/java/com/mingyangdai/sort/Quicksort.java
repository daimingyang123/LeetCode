package com.mingyangdai.sort;

/**
 * @author mingyang.dai
 * @since 2017/10/25
 */
public class Quicksort {
    
    public static void quicksort(int[] nums, int p, int r) {
        if (p >= r) return;
        int pivot = partition(nums, p, r);
        quicksort(nums, p, pivot-1);
        quicksort(nums, pivot+1, r);
    }
    
    private static int partition(int[] nums, int p, int r) {
        int q = p, j = p;
        while (j < r) {
            if (nums[j] < nums[r]) {
                swap(nums, j++, q++);
            } else {
                j++;
            }
        }
        swap(nums, q, r);
        return q;
    }
    
    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = {2,1,7,3,6,4,5};
        quicksort(nums, 0, nums.length-1);
        for (int n : nums) {
            System.out.print(n);
        }
    }
}
