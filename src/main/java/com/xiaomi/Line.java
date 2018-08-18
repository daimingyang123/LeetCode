package com.xiaomi;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/8/12
 */
public class Line {
	private static int[][] solution(int[][] array) {
		// 在此处理单行数据
		Arrays.sort(array, (o1, o2) -> {
			if (o1[0] == o2[0]) return o1[1] - o2[1];
			return o2[0] - o1[0];
		});
		
		List<int[]> res = new ArrayList<>();
		for (int[] p : array) {
			res.add(p[1], p);
		}
		// 返回处理后的结果
		return res.toArray(new int[array.length][array[0].length]);
	}
	
	public static void main(String args[]) {
		int[][] res = solution(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
		LinkedHashMap map = new LinkedHashMap<>();
		Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
		System.out.println(res);
	}
}
