package com.mingyangdai.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mingyang.dai
 * @since 2017/11/19
 */
public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		combine(candidates, target, 0, new ArrayList<>(), result);
		return result;
	}
	
	private static void combine(int[] candidates, int target, int i, List<Integer> cur, List<List<Integer>> result) {
		if(target == 0) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (; i<candidates.length && candidates[i]<=target; i++) {
			cur.add(candidates[i]);
			combine(candidates, target-candidates[i], i+1, cur, result);
			cur.remove(cur.size()-1);
//			 while (i<candidates.length-1 && candidates[i+1]==candidates[i]) i++;
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> res = combinationSum2(candidates, target);
		System.out.println(res);
	}
}
