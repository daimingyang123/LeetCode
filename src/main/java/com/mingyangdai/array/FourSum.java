package com.mingyangdai.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author daimingyang
 * @since 2018/10/18
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length && nums[k] <= target - nums[i] - nums[j]; k++) {
                    int last = target - nums[i] - nums[j] - nums[k];
                    if (last < nums[k]) break;
                    if (!map.containsKey(last)) continue;
                    
                    int count = 0;
                    if (last == nums[i]) {
                        count = 4;
                    } else if (last == nums[j]) {
                        count = 3;
                    } else if (last == nums[k]) {
                        count = 2;
                    }
                    if (map.get(last) < count) continue;
                    
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    list.add(target - nums[i] - nums[j] - nums[k]);
                    res.add(list);
                    
                    while (k < nums.length - 1 && nums[k] == nums[k + 1]) k++;
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        List<List<Integer>> res= new FourSum().fourSum(nums, target);
        System.out.println(res);
    }
}
