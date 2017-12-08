package com.mingyangdai.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2017/12/7
 */
public class DistinctSubsequences {
    //S = "rabbbit", T = "rabbit"
    
    public int numDistinct(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int[][] dp = new int[s.length()+1][t.length()];
//        dp[0] = 0;
        int sp = 0;
        
        for (int i=0, j = 0; i<s.length() && j < t.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), count);
    
            if (s.charAt(j) == t.charAt(i)) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    sp++;
                } else {
//                    dp[i] = dp[i-1] + 1;
                }
            }
    
            if (j > 0 && s.charAt(j) == t.charAt(i)) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    sp++;
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                int tp = 0;
                for (i += 1; i < t.length(); i++) {
                    if (t.charAt(i) == t.charAt(i - 1)) {
                        tp++;
                    }
                }
                if (s.charAt(j) == t.charAt(i)) {
                    dp[j] = dp[j - 1];
                } else {
    
                }
            }
        }
        return 0;
    }
    
    private int getCount(int s, int t) {
        int sf = 1;
        int min = s-t > t ? t : s-t;
        for (int i=min; i > 0; i--) {
            sf *= s;
            s--;
        }
        int tf = 1;
        for (int i=t; i > t; i--) {
            tf *= i;
        }
        return sf/tf;
    }
}
