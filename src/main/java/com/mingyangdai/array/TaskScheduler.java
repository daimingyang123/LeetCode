package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/5/2
 */
public class TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A'] += 1;
        }
        Arrays.sort(map);
        
        int last = 0, res = 0;
        while (map[25] > 0) {
            int i = 25;
            while (i >= 0 && map[i] > 0 && 25 - i < n) {
                map[i]--;
                i--;
            }
            last = 25 - i;
            res += n + 1;
            Arrays.sort(map);
        }
        res += last - n;
        return res;
    }
    
    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','B','B','C','C'};
        int n = 2;
        int res = new TaskScheduler().leastInterval(tasks, n);
        System.out.println(res);
    }
}
