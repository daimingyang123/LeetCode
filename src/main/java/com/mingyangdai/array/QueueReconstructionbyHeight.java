package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/10/3
 */
public class QueueReconstructionbyHeight {
	
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (o1, o2) -> {
			int diff = o1[1] - o2[1];
			return diff == 0 ? o1[0] - o2[0] : diff;
		});
		
		List<int[]> res = new ArrayList<>(people.length);
		for (int[] p : people) {
			int j = getIndex(p, res);
			res.add(j, p);
		}
		return res.toArray(people);
	}
	
	private int getIndex(int[] p, List<int[]> res) {
		int h = p[0], k = p[1];
		int i = 0, count = 0;
		for (; i < res.size(); i++) {
			if (res.get(i)[0] >= h) {
				if (count == k) break;
				count++;
			}
		}
		for (; i < res.size(); i++) {
			if (res.get(i)[0] < h) continue;
			break;
		}
		return i;
	}
	
	public static void main(String[] args) {
		QueueReconstructionbyHeight height = new QueueReconstructionbyHeight();
		int[][] people = {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};
		int[][] res = height.reconstructQueue(people);
		for (int[] array : res) {
			for (int item : array) {
				System.out.print(item);
				System.out.print(",");
			}
			System.out.println();
		}
	}
}
