package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/5/2
 */
public class TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
    
    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','C'};
        int n = 2;
        int res = new TaskScheduler().leastInterval(tasks, n);
        System.out.println(res);
    }
}
