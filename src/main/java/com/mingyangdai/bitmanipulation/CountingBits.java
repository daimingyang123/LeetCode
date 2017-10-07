package com.mingyangdai.bitmanipulation;

/**
 * @author mingyang.dai
 * @since 2017/9/26
 */
public class CountingBits {
    
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int num = 5;
        CountingBits bits = new CountingBits();
        int[] res = bits.countBits(num);
        System.out.println(res);
    }
}
