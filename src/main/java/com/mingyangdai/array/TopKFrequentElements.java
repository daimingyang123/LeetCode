package com.mingyangdai.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/9/28
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int p = 0, start = 0, end = nums.length;
        while (p+1 != k) {
            if (p+1 > k) end = p-1;
            else start = p+1;
            p = partition(nums, start, end);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<k; i++) {
            res.add(nums[i]);
        }
        return res;
    }
    
    private int partition(int[] nums, int p, int r) {
        int q = p;
        for (int j = p; j < r; j++) {
            if (nums[j] <= nums[r]) {
                swap(nums, j, q++);
            }
        }
        swap(nums, r, q);
        return q;
    }
    
    private void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
