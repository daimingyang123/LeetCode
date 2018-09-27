package com.xiaomi;

import java.util.*;

/**
 * @author daimingyang
 * @since 2018/7/23
 */
public class MostFrequent {
    
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : array[0].split(",")) {
            int key = Integer.parseInt(s);
            Integer count = map.get(key);
            if (count == null) count = 0;
            count++;
            map.put(key, count);
        }
        
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            List<Integer> list = treeMap.get(count);
            if (list == null) list = new ArrayList<>();
            list.add(entry.getKey());
            treeMap.put(count, list);
        }
        
        int count = 0, k = Integer.parseInt(array[1]);
        List<Integer> res = new ArrayList<>();
        while (count < k) {
            List<Integer> list = treeMap.pollLastEntry().getValue();
            res.addAll(list);
            count += list.size();
        }
        Collections.sort(res);
        
        StringBuilder builder = new StringBuilder();
        for (int n : res) {
            builder.append(n);
            builder.append(",");
        }
        // 返回处理后的结果
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
    
    public static void main(String[] args) {
        String line = "1,1,1,2,2,3 2";
        String res = solution(line);
        System.out.println(res);
    }
}
