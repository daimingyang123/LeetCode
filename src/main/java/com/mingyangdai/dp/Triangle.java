package com.mingyangdai.dp;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/11/25
 */
public class Triangle {
    
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        
        List<Integer> pre = triangle.get(0);
        for (int i=1; i<triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int sum = list.get(0) + pre.get(0);
            list.set(0, sum);
            sum = list.get(list.size()-1) + pre.get(pre.size()-1);
            list.set(list.size()-1, sum);
            
            for (int j=1; j<list.size()-1; j++) {
                sum = list.get(j) + Math.min(pre.get(j-1), pre.get(j));
                list.set(j, sum);
            }
            pre = list;
        }
        int min = Integer.MAX_VALUE;
        for (int n : pre) {
            min = min < n ? min : n;
        }
        return min;
    }
    
    public static void main(String[] args) {
        List<Integer> first = Lists.newArrayList(2);
        List<Integer> second = Lists.newArrayList(3, 4);
        List<List<Integer>> nums = Lists.newArrayList(first, second);
        int res = minimumTotal(nums);
        System.out.println(res);
    }
}
