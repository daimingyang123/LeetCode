package com.mingyangdai.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/9/19
 */
public class PossibleBipartition {
	
	public boolean possibleBipartition(int N, int[][] dislikes) {
		if (dislikes.length == 0) return true;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] d : dislikes) {
			List<Integer> nbhd = graph.getOrDefault(d[0], new ArrayList<>());
			nbhd.add(d[1]);
			graph.put(d[0], nbhd);
			
			if (!dfs(d[0], map.getOrDefault(d[0], 0), map, graph)) return false;
		}
		return true;
	}
	
	private boolean dfs(int p, int color, HashMap<Integer, Integer> map, HashMap<Integer, List<Integer>> graph) {
		Integer c = map.get(p);
		if (c == null && c != color) return false;
		map.put(p, color);
		
		for (Integer n : graph.getOrDefault(p, new ArrayList<>())) {
			if (!dfs(n, color^1, map, graph)) return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		int n = 10;
		int[][] dislikes = new int[][]{{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}};
		boolean res = new PossibleBipartition().possibleBipartition(n, dislikes);
		System.out.println(res);
	}
}
