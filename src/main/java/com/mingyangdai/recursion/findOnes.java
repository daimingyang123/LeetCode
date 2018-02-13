package com.mingyangdai.recursion;

/**
 * @author mingyang.dai
 * @since 2018/2/8
 */
public class findOnes {
    public static int findOnes(int n) {
        if (n<1) return 0;
        if (n>=1 && n<10) return 1;
        int y=1, x=n;
        while (!(x<10)) {
            x/=10;
            y*=10;
        }
        if(x==1)
            return n-y+1 + findOnes(y-1) + findOnes(n%y);
        else
            return y+ x*findOnes(y-1) + findOnes(n%y);
    }
    
    public static void main(String[] args) {
        int res = findOnes(1120);
        System.out.println(res);
    }
}
