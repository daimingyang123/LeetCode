package com.xiaomi;

import java.util.Arrays;

/**
 * @author daimingyang
 * @since 2018/7/23
 */
public class SumToZero {
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(",");
        int[] nums = new int[array.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(nums);
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] > 0) break;
                int index = Arrays.binarySearch(nums, j + 1, nums.length, -nums[i] - nums[j]);
                if (index > 0) count++;
            }
        }
        // 返回处理后的结果
        return Integer.toString(count);
    }
    
    public static void main(String[] args) {
        String line = "-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6";
        String res = solution(line);
        System.out.println(res);
    }
}
