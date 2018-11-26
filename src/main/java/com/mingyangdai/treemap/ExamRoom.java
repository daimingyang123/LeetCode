package com.mingyangdai.treemap;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class ExamRoom {
	private TreeMap<Integer, Integer> pMap;
	private TreeMap<Integer, TreeSet<Integer>> disMap;
	private int num;
	
	public ExamRoom(int N) {
		pMap = new TreeMap<>();
		disMap = new TreeMap<>((o1, o2) -> o2 - o1);
		num = N;
	}
	
	public int seat() {
		if (pMap.isEmpty()) {
			pMap.put(0, num - 1);
			TreeSet<Integer> set = new TreeSet<>();
			set.add(0);
			disMap.put(num - 1, set);
			return 0;
		}
		
		Map.Entry<Integer, TreeSet<Integer>> entry = disMap.firstEntry();
		TreeSet<Integer> set = entry.getValue();
		int pre = set.first();
		set.remove(pre);
		if (set.isEmpty()) {
			disMap.remove(entry.getKey());
		}
		pMap.remove(pre);
		
		Map.Entry<Integer, Integer> nextEntry = pMap.ceilingEntry(pre);
		if (nextEntry == null) {
			int next = num - 1;
			int dis = next - pre - 1;
			pMap.put(pre, dis);
			pMap.put(next, dis);
			
			set = disMap.getOrDefault(dis, new TreeSet<>());
			set.add(pre);
			set.add(next);
			disMap.put(dis, set);
			
			return next;
		}
		
		int next = nextEntry.getKey();
		set = disMap.get(nextEntry.getValue());
		set.remove(next);
		if (set.isEmpty()) {
			disMap.remove(entry.getKey());
		}
		pMap.remove(next);
		
		int dis = (next - pre)/2;
		int cur = pre + dis;
		
		pMap.put(pre, dis);
		pMap.put(cur, dis);
		pMap.put(next, dis);
		
		set = disMap.getOrDefault(dis, new TreeSet<>());
		set.add(pre);
		set.add(cur);
		set.add(next);
		disMap.put(dis, set);
		
		return cur;
	}
	
	public void leave(int p) {
		int dis = pMap.remove(p);
		TreeSet<Integer> set = disMap.get(dis);
		set.remove(p);
		if (set.isEmpty()) {
			disMap.remove(dis);
		}
		
		Map.Entry<Integer, Integer> entry = pMap.floorEntry(p);
		int pre = entry.getKey();
		set = disMap.get(entry.getValue());
		set.remove(pre);
		if (set.isEmpty()) {
			disMap.remove(entry.getKey());
		}
		pMap.remove(pre);
		
		entry = pMap.ceilingEntry(p);
		int next = entry.getKey();
		set = disMap.get(entry.getValue());
		set.remove(next);
		if (set.isEmpty()) {
			disMap.remove(entry.getKey());
		}
		pMap.remove(next);
		
		dis = next - pre;
		
		pMap.put(pre, dis);
		pMap.put(next, dis);
		
		set = disMap.getOrDefault(dis, new TreeSet<>());
		set.add(pre);
		set.add(next);
		disMap.put(dis, set);
	}
	
	public static void main(String[] args) {
		ExamRoom examRoom = new ExamRoom(10);
		int seat;
		
		seat = examRoom.seat();
		System.out.println(seat);
		
		seat = examRoom.seat();
		System.out.println(seat);
		
		seat = examRoom.seat();
		System.out.println(seat);
		
		examRoom.leave(0);
		examRoom.leave(4);
	}
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */

