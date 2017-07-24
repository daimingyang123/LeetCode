package com.mingyangdai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 17/2/4
 */
public class Knapsack {
	
	public static void main(String[] args) {
		Knapsack k = new Knapsack();
		int[] candidates = {1, 1, 2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> result = k.knapsack(candidates, target);
		System.out.println(result);
//        System.out.println("aabccb".substring(0,6));
	}
	
	public List<List<Integer>> knapsack(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		knapsack(candidates, 0, target, results, cur);
		return results;
	}
	
	public void knapsack(int[] candidates, int index, int target, List<List<Integer>> results, List<Integer> cur) {
		if (target < 0) return;
		if (target == 0) {
			results.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			cur.add(candidates[i]);
			knapsack(candidates, i + 1, target - candidates[i], results, cur);
			cur.remove(cur.size() - 1);
			while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
		}
		return;
	}
}
