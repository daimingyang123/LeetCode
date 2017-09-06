package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/8/29
 */
public class TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		Arrays.sort(buildings, Comparator.comparingInt(o -> o[2]));
		Map<int[], Integer> map = new LinkedHashMap<>();
		for (int[] b : buildings) {
			int[] array = new int[2];
			array[0] = b[0];
			array[1] = b[1];
			map.put(array, b[2]);
		}
		
		List<int[]> res = new ArrayList<>();
		TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
		for (int[] cur : map.keySet()) {
			int[] pre = set.lower(cur);
			if (pre != null) {
				if (map.get(cur) == map.get(pre)) {//same height
					cur[0] = pre[0];
					cur[1] = Math.max(cur[1], pre[1]);
				} else {//pre.height > cur.height
					if (cur[1] < pre[1]) continue;
					if (cur[0] < pre[1]) {
						cur[0] = pre[1];
					}
				}
			} else {
			
			}
			set.add(cur);
		}
		return null;
	}
}
