package com.xiaomi;

import java.util.*;

/**
 * @author daimingyang
 * @since 2018/7/19
 */
public class LeastExchange {
    private static String solution(String line) {
        // 在此处理单行数据
        List<Integer> list = new ArrayList<>();
        for (String s : line.split(",")) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        for (Integer num : list) {
            builder.append(num);
            builder.append(",");
        }
        String res = builder.toString();
        
        HashSet<String> set = new HashSet<>();
        set.add(line + ",");
        Integer count = 1;
        while (!set.isEmpty()) {
            HashSet<String> set2 = new HashSet<>();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String s = it.next();
                HashSet<String> exchange = exchange(s);
                if (exchange.contains(res)) return count.toString();
                set2.addAll(exchange);
            }
            count++;
            set = set2;
        }
        // 返回处理后的结果
        return "-1";
    }
    
    private static HashSet<String> exchange(String s) {
        HashSet<String> res = new HashSet<>();
        char[] array = s.toCharArray();
        for (int i = 0; i+2 < array.length; i+=2) {
            char c = array[i];
            array[i] = array[i + 2];
            array[i + 2] = c;
            res.add(new String(array));
            array[i + 2] = array[i];
            array[i] = c;
        }
        return res;
    }
    
    public static void main(String[] args) {
        String line = "2,3,1";
        String res = solution(line);
        System.out.println(res);
    }
}
