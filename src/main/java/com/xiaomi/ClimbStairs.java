package com.xiaomi;

/**
 * @author daimingyang
 * @since 2018/7/20
 */
public class ClimbStairs {
    private static String solution(String line) {
        // 在此处理单行数据
        int floor = Integer.parseInt(line);
        if (floor < 3) return Integer.toString(floor);
        
        int[] dp = new int[floor + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= floor; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回处理后的结果
        return Integer.toString(dp[floor]);
    }
    
    public static void main(String[] args) {
        String line = "5";
        String res = solution(line);
        System.out.println(res);
    }
}
