package com.mingyangdai.recursion;

/**
 * @author daimingyang
 * @since 2018/7/19
 */
public class IntersectionString {
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(",");
        if (array[0].length() + array[1].length() != array[2].length()) return "false";
        // 返回处理后的结果
        boolean res = solve(array[0].toCharArray(), 0, array[1].toCharArray(), 0, new StringBuilder(), array[2]);
        return Boolean.toString(res);
    }
    
    private static boolean solve(char[] a, int i, char[] b, int j, StringBuilder cur, String res) {
        if (i == a.length && j == b.length) {
            System.out.println(cur.toString());
            return cur.toString().equals(res);
        }
        if (i == a.length && j != b.length) {
            cur.append(b[j]);
            if (solve(a, i, b, j + 1, cur, res)) return true;
            cur.deleteCharAt(cur.length() - 1);
        } else if (i != a.length && j == b.length) {
            cur.append(a[i]);
            if (solve(a, i + 1, b, j, cur, res)) return true;
            cur.deleteCharAt(cur.length() - 1);
        } else {
            cur.append(a[i]);
            if (solve(a, i + 1, b, j, cur, res)) return true;
            cur.deleteCharAt(cur.length() - 1);
            cur.append(b[j]);
            if (solve(a, i, b, j + 1, cur, res)) return true;
            cur.deleteCharAt(cur.length() - 1);
        }
        return false;
    }
    
    public static void main(String[] args) {
//        String line = "aabcc,dbbca,aadbbcbcac";
//        String res = solution(line);
//        System.out.println(res);
    
    }
}
