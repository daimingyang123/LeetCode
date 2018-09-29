package com.mingyangdai.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2018/9/23
 */
public class EvaluateDivision {
	private HashMap<String, List<String>> graph;
	private HashMap<String, Double> map;
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		graph = new HashMap<>();
		map = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			map.put(equations[i][0] + equations[i][0], 1D);
			List<String> list = graph.getOrDefault(equations[i][0], new ArrayList<>());
			list.add(equations[i][1]);
			graph.put(equations[i][0], list);
			map.put(equations[i][0] + equations[i][1], values[i]);
			
			map.put(equations[i][1] + equations[i][1], 1D);
			list = graph.getOrDefault(equations[i][1], new ArrayList<>());
			list.add(equations[i][0]);
			graph.put(equations[i][1], list);
			map.put(equations[i][1] + equations[i][0], 1/values[i]);
		}
		
		double[] res = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			HashSet<String> visited = new HashSet<>();
			visited.add(queries[i][0]);
			res[i] = query(queries[i][0], queries[i][1], visited);
		}
		return res;
	}
	
	private Double query(String start, String end, HashSet<String> visited) {
		if (!map.containsKey(start + start)) {
			return -1D;
		}
		if (start.equals(end)) {
			return 1D;
		}
		if (map.containsKey(start + end)) {
			return map.get(start + end);
		}
		if (map.containsKey(end + start)) {
			return map.get(end + start);
		}
		for (String next : graph.getOrDefault(start, new ArrayList<>())) {
			if (visited.contains(next)) continue;
			
			visited.add(next);
			Double val = query(next, end, visited);
			if (val != -1) {
				visited.remove(next);
				return map.get(start + next) * val;
			}
		}
		return -1D;
	}
	
	public static void main(String args[]) {
		String[][] equations = { {"a","b"},{"b","c"} };
		double[] values = {2.0,3.0};
		String[][] queries = { {"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
		double[] res = new EvaluateDivision().calcEquation(equations, values, queries);
		System.out.println(res);
	}
}
