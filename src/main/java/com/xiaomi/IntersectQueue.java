package com.xiaomi;

/**
 * @author mingyang.dai
 * @since 2018/7/14
 */
public class IntersectQueue {
	private static String solution(String line) {
		// 在此处理单行数据
		String[] array = line.split(",");
		char[] f = array[0].toCharArray(), s = array[1].toCharArray(), res = array[2].toCharArray();
		if (f.length + s.length != res.length) return "false";
		
		int i = 0, j = 0;
		for (int k = 0; k < res.length; k++) {
			if (i == f.length) {
				if (res[k] == s[j]) j++;
				else return "false";
			} else if (j == s.length) {
				if (res[k] == f[i]) i++;
				else return "false";
			} else {
				if (res[k] == f[i]) i++;
				else if (res[k] == s[j]) j++;
				else return "false";
			}
		}
		// 返回处理后的结果
		return "true";
	}
	
	public static void main(String[] args) {
		String line = "aabcc,dbbca,aadbbcbcac";
		String res = solution(line);
		System.out.println(res);
	}
}
