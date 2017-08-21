package com.mingyangdai.math;

import java.util.Arrays;

/**
 * @author mingyang.dai
 * @since 2017/8/21
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if (n == 1) return 0;
        return getSteps(1,1, n,1);
    }
    
    private int getSteps(int pre, int cur, int target, int steps) {
        if (cur == target) return steps;
        if (cur > target) return Integer.MAX_VALUE;
        return Math.min(
                getSteps(pre, cur+pre, target, steps+1),
                getSteps(cur, cur*2, target,steps+2));
    }
    
    public static void main(String[] args) {
        TwoKeysKeyboard keyboard = new TwoKeysKeyboard();
        int n = 8;
        int res = keyboard.minSteps(n);
        System.out.println(res);
        int[] array = {};
        Arrays.sort(array, 0, 1);
    }
}
