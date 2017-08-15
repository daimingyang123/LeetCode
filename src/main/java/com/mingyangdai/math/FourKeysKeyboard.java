package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2017/8/14
 */
public class FourKeysKeyboard {
    
    public int maxA(int N) {
        if (N<7) return N;
    
        N -= 3;
        int cur = 3;
        int max = cur;
        if (N > 3) {
            N -= 3;
            max += cur;
        }
        
        while (N > 6) {
            N -= 6;
            max += 12*cur;
        }
        while (N > 0) {
            N -= 1;
            max += cur;
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        FourKeysKeyboard keyboard = new FourKeysKeyboard();
        int n = 10;
        int res = keyboard.maxA(n);
        System.out.println(res);
    }
}
