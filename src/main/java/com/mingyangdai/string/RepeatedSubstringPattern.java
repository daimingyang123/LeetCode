package com.mingyangdai.string;

/**
 * @author mingyang.dai
 * @since 2018/6/6
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int len = 1; len <= s.length()/2; len++) {
            String p = s.substring(0, len);
            boolean flag = true;
            int i = len;
            for (; i + len <= s.length(); i+=len) {
                if (!s.substring(i, i + len).equals(p)) {
                    flag = false;
                    break;
                }
            }
            if (flag && i == s.length()) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        boolean res = new RepeatedSubstringPattern().repeatedSubstringPattern("abab");
        System.out.println(res);
    }
}
