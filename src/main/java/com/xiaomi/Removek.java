package com.xiaomi;

/**
 * @author daimingyang
 * @since 2018/7/19
 */
public class Removek {
    private static Integer min = Integer.MAX_VALUE;
    
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(",");
        int k = Integer.parseInt(array[1]);
        if (line.length() == k) return "0";
        
        append(array[0].toCharArray(), 0, new StringBuilder(), array[0].length() - k);
        // 返回处理后的结果
        return min.toString();
    }
    
    private static void append(char[] array, int i, StringBuilder cur, int length) {
        if (cur.length() == length) {
            min = Math.min(min, Integer.parseInt(cur.toString()));
            return;
        }
        for (int j = i; j < array.length; j++) {
            cur.append(array[j]);
            append(array, j + 1, cur, length);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        String line = "1432219,3";
        String res = solution(line);
        System.out.println(res);
    
        int[] dp = new int[3 + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
    }
}
