package com.xiaomi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daimingyang
 * @since 2018/8/1
 */
public class Encrypt {
    
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(",");
        int[] cur = new int[26];
        for (char c : array[0].toCharArray()) {
            cur[c - 'A']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : cur) {
            Integer val = map.get(key);
            if (val == null) val = 0;
            val++;
            map.put(key, val);
        }
        
        int[] target = new int[26];
        for (char c : array[1].toCharArray()) {
            target[c - 'A']++;
        }
        for (int key : target) {
            Integer value = map.get(key);
            if (value == null || value == 0) return "NO";
            value--;
            map.put(key, value);
        }
        // 返回处理后的结果
        return "YES";
    }
    
    public static void main(String[] args) {
        String line = "VICTORIOUS,JWPUDJSTVP";
        String res = solution(line);
        System.out.println(res);
    }
}
