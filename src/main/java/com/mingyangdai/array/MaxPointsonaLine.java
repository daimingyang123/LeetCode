package com.mingyangdai.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author mingyang.dai
 * @since 2017/10/28
 */
public class MaxPointsonaLine {
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	public static int maxPoints(Point[] points) {
		if (points.length < 3) return points.length;
		
		int base = 0;
		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();
		Map<Double, Integer> zMap = new HashMap<>();
		Map<Integer, HashSet<Point>> map = new HashMap<>();
		for (Point point : points) {
			int x = point.x;
			int y = point.y;
			if (x == 0 && y == 0) {
				base++;
			}
			int count = xMap.getOrDefault(x, 0) + 1;
			xMap.put(x, count);
			count = yMap.getOrDefault(y, 0) + 1;
			yMap.put(y, count);
			Double z = (double) x/(double) y;
			count = zMap.getOrDefault(z, 0) + 1;
			zMap.put(z, count);
			
			HashSet<Point> set = map.getOrDefault(x, new HashSet<>());
			if (set.size() == 1) {
				Point origin = set.iterator().next();
				if (x != origin.x || y != origin.y) {
					set.add(point);
				}
			} else {
				set.add(point);
			}
			map.put(x, set);
		}
		
		if (base != 0) {
			int count = zMap.getOrDefault(0d, 0) + base;
			zMap.put(0d, count);
			
			count = zMap.getOrDefault(1d, 0) + base;
			zMap.put(1d, count);
		}
		
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
			Integer x = entry.getKey();
			int count = entry.getValue();
			if (map.get(x).size() == 1 && map.size() != 1) {
				count++;
			}
			max = Math.max(max, count);
		}
		for (Integer count : yMap.values()) {
			max = Math.max(max, count);
		}
		for (Integer count : zMap.values()) {
			max = Math.max(max, count);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Point[] points = {new Point(1,1), new Point(1,1), new Point(2,3)};
		int res = maxPoints(points);
		System.out.println(res);
	}
}
