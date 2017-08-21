package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/8/20
 */
public class HostCrowding {
    
    private static Queue<String> dup;
    private static HashSet<String> set;
    /*
     * Complete the function below.
     */
    static String[] paginate(int num, String[] results) {
        dup = new LinkedList<>();
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        
        paginate(num, results, cur, 0, res);
        String[] strings = new String[res.size()];
        return res.toArray(strings);
    }
    
    private static void paginate(int num, String[] results, List<String>cur, int start, List<String> res) {
        set = new HashSet<>();
        
        if (start == results.length) {
            if (!dup.isEmpty()) {
                results = new String[dup.size()];
                results = dup.toArray(results);
                dup.clear();
                paginate(num, results, cur, 0, res);
            } else {
                res.addAll(cur);
            }
            return;
        }
        
        while (cur.size() < num && !dup.isEmpty()) {
            String s = dup.peek();
            String host = getHost(s);
            if (set.add(host)) {
                cur.add(dup.poll());
            } else {
                dup.offer(s);
            }
        }
        
        boolean flag = false;
        while (cur.size() < num && start < results.length) {
            flag = true;
            String s = results[start];
            String host = getHost(s);
            if (set.add(host)) {
                cur.add(s);
            } else {
                dup.offer(s);
            }
            start++;
        }
        if (flag) start--;
        
        if (cur.size() == num) {
            cur.add("");
            res.addAll(cur);
            cur = new ArrayList<>();
        }
        
        paginate(num, results, cur, start+1, res);
    }
    
    private static String getHost(String s) {
        return s.split(",")[0];
    }
    
    public static void main(String[] args) {
        int num = 5;
        String[] results = {
                "1,1",
                "2,1",
                "3,1",
                "1,2",
                "5,1"
        };
        String[] res = paginate(num, results);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
