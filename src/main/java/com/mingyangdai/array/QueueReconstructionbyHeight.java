package com.mingyangdai.array;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/10/3
 */
public class QueueReconstructionbyHeight {
	
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, Comparator.comparingInt(o -> o[1]));
		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		//sort by k
		for (int[] item : people) {
			List<int[]> list = map.getOrDefault(item[1], new ArrayList<>());
			list.add(item);
			map.put(item[1], list);
		}
		
		LinkedList<int[]> res = new LinkedList<>();
		for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
			List<int[]> list = entry.getValue();
			//sort by h
			list.sort((o1, o2) -> o2[0]-o1[0]);
			for (int[] item : list) {
				int count = 0;
				for (int[] array : res) {
					if (array[0] >= item[0]) count++;
				}
				if (count == item[1]) list.add(item);
				else res.add(count-item[1], item);
			}
		}
		
		people = new int[people.length][2];
		return res.toArray(people);
	}
	
	public static void main(String[] args) {
		QueueReconstructionbyHeight height = new QueueReconstructionbyHeight();
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
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
