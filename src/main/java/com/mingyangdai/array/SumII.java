package com.mingyangdai.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author mingyang.dai
 * @since 2018/6/6
 */
public class SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int len = A.length;
        if (len == 0) return res;
        
        TreeMap<Integer, int[]> treeMap = new TreeMap<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int[] range = treeMap.getOrDefault(C[i], new int[]{-1, -1});
            if (range[0] == -1) range[0] = i;
            range[1] = i;
            treeMap.put(C[i], range);
            
            int count = hashMap.getOrDefault(D[i], 0) + 1;
            hashMap.put(D[i], count);
            min = Math.min(min, D[i]);
            max = Math.max(max, D[i]);
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Map.Entry<Integer, int[]> entry = treeMap.ceilingEntry(0 - A[i] - B[j] - max);
                if (entry == null) continue;
                
                int s = entry.getValue()[0];
                entry = treeMap.floorEntry(0 - A[i] - B[j] - min);
                if (entry == null) continue;
                
                int e = entry.getValue()[1];
                while (s <= e) {
                    int diff = 0 - A[i] - B[j] - C[s];
                    Integer count = hashMap.get(diff);
                    if (count != null) res += count;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, -1};
        int[] B = new int[]{-1, 1, 0};
        int[] C = new int[]{0, 0, 1};
        int[] D = new int[]{-1, 1, 1};
        int res = new SumII().fourSumCount(A, B, C, D);
        System.out.println(res);
    }
}
