package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/8/29
 */
public class TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = Arrays.asList();
		Collections.sort(res, Comparator.comparingInt(o -> o[2]));
		TreeMap<Integer, int[]> map = new TreeMap<>();
		for (int[] b : buildings) {
			map.put(b[2], b);
		}

		for (int i = 0; i < res.size(); i++) {
			int[] h = res.get(i);
			for (int[] l : map.headMap(h[2]).values()) {
				if (l[0]>=h[0] && l[0]<h[1]) {
					if (l[1] <= h[1]) {

					}
				}
				if (l[0]>h[1] && l[1]<h[0]) {

				}
			}
		}
		return null;
	}
}
