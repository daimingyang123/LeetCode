package com.xiaomi;

/**
 * @author daimingyang
 * @since 2018/7/20
 */
public class Construct {
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");
        int[] map = new int[26];
        char[] array1 = array[1].toCharArray();
        for (int i = 0; i < array1.length; i++) {
            int key = array1[i] - 'a';
            map[key]++;
        }
        char[] array0 = array[0].toCharArray();
        for (int i = 0; i < array0.length; i++) {
            int key = array0[i] - 'a';
            map[key]--;
            if (map[key] < 0) return "false";
        }
        // 返回处理后的结果
        return "true";
    }
    
    public static void main(String[] args) {
        String line = "aa aab";
        String res = solution(line);
        System.out.println(res);
    }
}
