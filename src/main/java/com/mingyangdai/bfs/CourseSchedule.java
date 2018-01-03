package com.mingyangdai.bfs;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/1/1
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, Integer> degree = new HashMap<>();
		for (int i=0; i<numCourses; i++) {
			degree.put(i, 0);
		}
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for (int[] array : prerequisites) {
			HashSet<Integer> set = map.getOrDefault(array[1], new HashSet<>());
			set.add(array[0]);
			map.put(array[1], set);
			Integer d = degree.get(array[0]) + 1;
			degree.put(array[0], d);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
			if (entry.getValue() == 0) {
				queue.offer(entry.getKey());
			}
		}
		if (queue.isEmpty()) return false;
		
		while (!queue.isEmpty()) {
			Queue<Integer> queue2 = new LinkedList<>();
			Integer course = queue.poll();
			HashSet<Integer> cs = map.remove(course);
			if (cs == null) continue;
			for (Integer c : cs) {
				Integer d = degree.get(c) - 1;
				if (d == 0) {
					queue2.offer(c);
				} else {
					degree.put(c, d);
				}
			}
			queue = queue2;
		}
		
		return map.isEmpty();
	}
	
	public static void main(String[] args) {
		CourseSchedule schedule = new CourseSchedule();
		int num = 3;
		int[][] array = {{2,0}, {2,1}};
		boolean res = schedule.canFinish(num, array);
		System.out.println(res);
	}
}
