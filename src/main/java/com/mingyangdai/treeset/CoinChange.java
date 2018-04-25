package com.mingyangdai.treeset;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2018/4/23
 */
public class CoinChange {
	
	public int coinChange(int[] coins, int amount) {
		TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
		for (int coin : coins) {
			map.put(coin, 1);
		}
		return coinChange(map, 0, 0, amount);
	}
	
	private int coinChange(TreeMap<Integer, Integer> map, int cur, int sum, int target) {
		if (sum != 0) map.put(sum, cur);
		
		Integer count = map.get(target - sum);
		if (count != null) return cur + count;
		
		NavigableMap<Integer, Integer> tailMap = map.tailMap(target - sum, true);
		if (tailMap.isEmpty()) return -1;
		
		Set<Integer> set = new HashSet<>();
		set.addAll(tailMap.keySet());
		for (Integer coin : set) {
			count = coinChange(map, cur + 1, sum + coin, target);
			if (count != -1) return count;
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		[186,419,83,408]
//		6249
		int[] coins = new int[]{186,419,83,408};
		int amount = 6249;
		int res = new CoinChange().coinChange(coins, amount);
		System.out.println(res);
	}
}
