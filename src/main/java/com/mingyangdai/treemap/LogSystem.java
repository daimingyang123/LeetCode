package com.mingyangdai.treemap;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/9/7
 */
public class LogSystem {
	
	private HashMap<String, Integer> graLen = new HashMap<>();
	private HashMap<String, TreeMap<Long, List<Integer>>> map = new HashMap<>();
	
	public LogSystem() {
		graLen.put("Year", 4);
		graLen.put("Month", 6);
		graLen.put("Day", 8);
		graLen.put("Hour", 10);
		graLen.put("Minute", 12);
		graLen.put("Second", 14);
	}
	
	public void put(int id, String timestamp) {
		timestamp = timestamp.replaceAll(":", "");
		for (Map.Entry<String, Integer> entry : graLen.entrySet()) {
			String gra = entry.getKey();
			Integer len = entry.getValue();
			
			TreeMap<Long, List<Integer>> treeMap = map.getOrDefault(gra, new TreeMap<>());
			Long time = getTime(timestamp, len);
			List<Integer> list = treeMap.getOrDefault(time, new ArrayList<>());
			list.add(id);
			
			treeMap.put(time, list);
			map.put(gra, treeMap);
		}
	}
	
	private Long getTime(String timestamp, int length) {
		String s = timestamp.substring(0, length);
		return Long.parseLong(s);
	}
	
	public List<Integer> retrieve(String s, String e, String gra) {
		List<Integer> res = new ArrayList<>();
		
		TreeMap<Long, List<Integer>> treeMap = map.get(gra);
		Integer len = graLen.get(gra);
		Long start = getTime(s.replaceAll(":", ""), len);
		Long end = getTime(e.replaceAll(":", ""), len);
		
		for (Map.Entry<Long, List<Integer>> entry : treeMap.tailMap(start, true).entrySet()) {
			Long time = entry.getKey();
			if (time > end) break;
			res.addAll(entry.getValue());
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		LogSystem logSystem = new LogSystem();
		logSystem.put(1, "2017:01:01:23:59:59");
		logSystem.put(2, "2017:01:01:22:59:59");
		logSystem.put(3, "2016:01:01:00:00:00");
		
		List<Integer> list = logSystem.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
		System.out.println(list.size());
	}
}
