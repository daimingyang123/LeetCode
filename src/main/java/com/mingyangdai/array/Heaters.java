package com.mingyangdai.array;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author mingyang.dai
 * @since 2018/6/4
 */
public class Heaters {
	
	public int findRadius(int[] houses, int[] heaters) {
		TreeSet<Integer> houseSet = new TreeSet<>();
		for (int h : houses) {
			houseSet.add(h);
		}
		HashSet<Integer> heaterSet = new HashSet<>();
		for (int h : heaters) {
			if (houseSet.remove(h)) heaterSet.add(h);
		}
		
		int radius = Integer.MAX_VALUE;
		while (!houseSet.isEmpty()) {
			radius = Integer.MAX_VALUE;
			for (int h : heaters) {
				Integer i = houseSet.ceiling(h);
				if (i != null) radius = Math.min(radius, i - h);
				i = houseSet.floor(h);
				if (i != null) radius = Math.min(radius, h - i);
			}
			for (int h : heaters) {
				if (houseSet.remove(h - radius)) heaterSet.add(h - radius);
				if (houseSet.remove(h + radius)) heaterSet.add(h + radius);
			}
		}
		return radius;
	}
	
	public static void main(String[] args) {
		int[] houses = new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
		int[] heaters = new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
		int res = new Heaters().findRadius(houses, heaters);
		System.out.println(res);
	}
}
