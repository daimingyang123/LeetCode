package com.mingyangdai.treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author mingyang.dai
 * @since 2018/7/22
 */
public class WalkingRobotSimulation {
	
	public int robotSim(int[] commands, int[][] obstacles) {
		Map<Integer, TreeSet<Integer>> xMap = new HashMap<>();
		Map<Integer, TreeSet<Integer>> yMap = new HashMap<>();
		for (int[] obs : obstacles) {
			TreeSet<Integer> set = xMap.getOrDefault(obs[0], new TreeSet<>());
			set.add(obs[1]);
			xMap.put(obs[0], set);
			
			set = yMap.getOrDefault(obs[1], new TreeSet<>());
			set.add(obs[0]);
			yMap.put(obs[1], set);
		}
		
		int i = 0;
		int[] pre = new int[2], cur = new int[2];
		int[] x = new int[]{0, 1, 0, -1};
		int[] y = new int[]{1, 0, -1, 0};
		
		for (int com : commands) {
			if (com == -2) {
				i--;
				continue;
			} else if (com == -1) {
				i++;
				continue;
			}
			i %= 4;
			
			cur[0] = pre[0] + x[i]*com;
			cur[1] = pre[1] + y[i]*com;
			
			switch (i) {
				case 0:
					TreeSet<Integer> set = xMap.getOrDefault(pre[0], new TreeSet<>());
					Integer key = set.higher(pre[1]);
					if (key != null && key <= cur[1]) {
						cur[1] = key - 1;
					}
					break;
				case 1:
					set = yMap.getOrDefault(pre[1], new TreeSet<>());
					key = set.higher(pre[0]);
					if (key != null && key <= cur[0]) {
						cur[0] = key - 1;
					}
					break;
				case 2:
					set = xMap.getOrDefault(pre[0], new TreeSet<>());
					key = set.lower(pre[1]);
					if (key != null && key >= cur[1]) {
						cur[1] = key + 1;
					}
					break;
				case 3:
					set = yMap.getOrDefault(pre[1], new TreeSet<>());
					key = set.lower(pre[0]);
					if (key != null && key >= cur[0]) {
						cur[0] = key + 1;
					}
					break;
			}
			
			pre[0] = cur[0];
			pre[1] = cur[1];
		}
		
		return cur[0]*cur[0] + cur[1]*cur[1];
	}
	
	public static void main(String args[]) {
		int[] commands = {4,-1,4,-2,4};
		int[][] obstacles = {{2,4}};
		int res = new WalkingRobotSimulation().robotSim(commands, obstacles);
		System.out.println(res);
	}
}
