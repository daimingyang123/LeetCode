package com.mingyangdai.math;

/**
 * @author mingyang.dai
 * @since 2018/3/5
 */
public class FactorialTrailingZeroes {
    
    public int trailingZeroes(int n) {
        int count = 0;
        for (int d=5; n/d>0; d*=5) {
            count += n/d;
            if (d > Integer.MAX_VALUE/5) break;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int n = 1808548329;
        int res = new FactorialTrailingZeroes().trailingZeroes(n);
        System.out.println(res);
    }
}
